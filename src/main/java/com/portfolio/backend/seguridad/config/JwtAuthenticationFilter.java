package com.portfolio.backend.seguridad.config;

import com.portfolio.backend.seguridad.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
// import java.security.Security;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

   private final JwtService jwtService;
   private final UserDetailsService userDetailsService;
   private final TokenRepository tokenRepository;

   @Override
   protected void doFilterInternal(
         @NonNull HttpServletRequest request,
         @NonNull HttpServletResponse response,
         @NonNull FilterChain filterChain) throws ServletException, IOException {
      final String authHeader = request.getHeader("Authorization");
      // System.out.println("-----> Token recibido para autorizar: " + authHeader);
      final String jwt;
      final String username;
      if (authHeader == null || !authHeader.startsWith("Bearer ")) {
         filterChain.doFilter(request, response);
         return;
      }
      jwt = authHeader.substring(7);
      // System.out.println("-----> jwt: " + jwt);
      username = jwtService.extractUsername(jwt);
      // System.out.println("-----> username: " + username);
      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
         UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
         // System.out.println("-----> UserDetails: " + userDetails.getUsername() + ", "
         // + userDetails.getAuthorities());
         var isTokenValid = tokenRepository.findByToken(jwt)
               .map(t -> !t.isExpired() && !t.isRevoked())
               .orElse(false);
         // System.out.println("-----> isTokenValid: " + isTokenValid);
         if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                  userDetails.getUsername(),
                  null,
                  userDetails.getAuthorities());
            // System.out.println("-----> authToken: " + authToken.getName() + ", " +
            // authToken.getPrincipal() + ", " + authToken.getAuthorities());
            authToken.setDetails(
                  new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
         }
      }
      filterChain.doFilter(request, response);
   }
}
