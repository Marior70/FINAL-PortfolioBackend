package com.portfolio.backend.seguridad.filtros;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.portfolio.backend.seguridad.token.TokenUtils;

/* import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; */
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
      System.out.println();
      System.out.println("-----------> JWTAuthorizationFilter / doFilterInternal");
      System.out.println();
      String bearerToken = request.getHeader("Authorization");
      if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
         String token = bearerToken.replace("Bearer ", "");
         UsernamePasswordAuthenticationToken usernamePAT = TokenUtils.getAuthentication(token);
         SecurityContextHolder.getContext().setAuthentication(usernamePAT);

         System.out.println("-----------> JWTAuthorizationFilter / doFilterInternal / usernamePAT: " + usernamePAT);
         System.out.println();
      }
      filterChain.doFilter(request, response);
   }
}
