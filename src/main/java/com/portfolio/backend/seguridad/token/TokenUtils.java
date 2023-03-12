package com.portfolio.backend.seguridad.token;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.portfolio.backend.seguridad.roles.Rol;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {

   private final static String jwtSecret = "cl4v3su93r$3cr3t4cl4v3su93r$3cr3t4";
   private final static Long jwtExpiracion = 86400L;
   
   // @Value("${appJwtSecret}")
   // private final static String jwtSecret;

   // @Value("${appJwtExpiration}")
   // private final static Long jwtExpiration;

   // Creamos el token a enviar al cliente
   public static String crearToken(String username, String name, Set<Rol> roles){
      Long tiempoExpiracion = jwtExpiracion * 1_000; // Lo pasamos a milisegundos
      Date diaExpiracion = new Date(System.currentTimeMillis() + tiempoExpiracion);
      
      // El extra es los datos que agregamos al token payload
      Map<String, Object> extra = new HashMap<>();
      // extra.put("name", name);
      extra.put("roles", roles);

      return Jwts.builder()
         .setSubject(username)
         .setExpiration(diaExpiracion)
         .addClaims(extra)
         .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes())) // para java 11
         //.signWith(SignatureAlgorithm.HS256,jwtSecret.getBytes()) // para java 17
         .compact();
   }

   // Método que retorna el usernamePasswordAuthToken que Spring reconozca y permita pasar el proceso a autorización al usuario que está accediendo a un endpoint de un recurso protegido
   public static UsernamePasswordAuthenticationToken getAuthentication(String token) { // token es el recibido desde el cliente
      try {
         Claims claims = Jwts.parserBuilder() // El parserBuilder es el proceso inverso al que hicimos con el Builder
            .setSigningKey(jwtSecret.getBytes())
            .build()
            .parseClaimsJws(token)
            .getBody();
         String username = claims.getSubject();

      return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList()); // contiene el username, vacio y una lista vacia
      } catch (JwtException e) {
         return null; // No se ha podido crear el usernamepasswordauthentication token a partir del token recibido.
      }     
   }   

}
