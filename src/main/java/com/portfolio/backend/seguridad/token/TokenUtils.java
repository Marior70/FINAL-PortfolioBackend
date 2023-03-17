package com.portfolio.backend.seguridad.token;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AbstractAuthenticationToken;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;

// import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {

   private final static String jwtSecret = "$2a$10$gjbd4nmoAqy2nbAAt7Wwu.0L3zzDrvDw.ZLTWaSYCgYx7UNZdbtrG";
   private final static Long jwtExpiracion = 86400L;

   // @Value("${app.jwtSecret}")
   // private static String jwtSecret;

   // @Value("${app.jwtExpiracion}")
   // private static Long jwtExpiracion;

   // Creamos el token a enviar al cliente
   public static String crearToken(String username, String name, String entidad,
         Collection<? extends GrantedAuthority> authorities) {
      Long tiempoExpiracion = jwtExpiracion * 1_000; // Lo pasamos a milisegundos
      Date diaExpiracion = new Date(System.currentTimeMillis() + tiempoExpiracion);

      System.out.println("-----> diaExpiración: " + diaExpiracion);
      System.out.println();

      // El extra es los datos que agregamos al token payload
      Map<String, Object> extra = new HashMap<>();
      extra.put("name", name);
      extra.put("entidad", entidad);
      extra.put("authorities", authorities);

      return Jwts.builder()
            // .setHeaderParam("alg", "HS256")
            .setHeaderParam("typ", "JWT")
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(diaExpiracion)
            .addClaims(extra)
            .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
            // .signWith(SignatureAlgorithm.HS256, jwtSecret.getBytes())
            .compact();
   }

   // Método que retorna el usernamePasswordAuthToken que Spring reconozca y
   // permita pasar el proceso a autorización al usuario que está accediendo a un
   // endpoint de un recurso protegido
   public static UsernamePasswordAuthenticationToken getAuthentication(String token) { // token es el recibido desde el cliente
   
      Claims claims = Jwts.parserBuilder() // El parserBuilder es el proceso inverso al que hicimos con el Builder
            .setSigningKey(jwtSecret.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();
      String username = claims.getSubject();
      Collection<? extends GrantedAuthority> authorities = ((AbstractAuthenticationToken) claims).getAuthorities();
      
      return new UsernamePasswordAuthenticationToken(username, null, authorities);
   }
}
