package com.portfolio.backend.seguridad.filtros;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.backend.seguridad.impl.UserDetailsImpl;
import com.portfolio.backend.seguridad.token.TokenUtils;
import com.portfolio.backend.seguridad.usuarios.AuthCredenciales;

/* Hasta Sprint Boot 2.7 */
/* import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; */
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

   @Override
   public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

            AuthCredenciales authCredenciales = new AuthCredenciales();
            try {
            authCredenciales = new ObjectMapper().readValue(request.getReader(), AuthCredenciales.class);
            } catch (IOException e){
               System.out.println("Formato de credenciales inválidos");
            }

            UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(authCredenciales.getUsername(),authCredenciales.getPassword(),Collections.emptyList());

            return getAuthenticationManager().authenticate(usernamePAT);
   }

   @Override
   protected void successfulAuthentication(HttpServletRequest request,
                                          HttpServletResponse response,
                                          FilterChain chain,
                                          Authentication authResult) throws IOException,ServletException {
      
      UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();

      System.out.println("UserDetails: " + userDetails.getUsername() + ", " + userDetails.getName() + ", " + userDetails.getRoles()); 
      
      String token = TokenUtils.crearToken(userDetails.getUsername(), userDetails.getName(), userDetails.getRoles());
      response.addHeader("Authorization", "Bearer " + token);
      response.getWriter().flush();
      super.successfulAuthentication(request, response, chain, authResult);

      
      System.out.println();
      System.out.println("Token: " + token);
      System.out.println();
      System.out.println("Request: " + request);
      System.out.println();
      System.out.println("Response: " + response);
      System.out.println();
      System.out.println("Chain: " + chain);
      System.out.println();
      System.out.println("Response: " + authResult);
      System.out.println();
   }

}