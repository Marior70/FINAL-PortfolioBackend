package com.portfolio.backend.seguridad.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

   private static final String SECRET_KEY =
   "KcDfVwIl8ZP/v0arUDlPq7l/6nnL9SodpVykyEXaA1PHYsCS2IiDasNvv38QtUwRg9IggeNz2x7xyFYD/oFOCvC2n8bSf+CezjeQkl60wzELjj+F0/fRiwW1m/CfqLNlwkDsKkN8oKTAI16uUhE/ZQBQ8rnAAZ2xbrTURtw3+4JnJH6+/3ki9QiRjQ0c2+V9krsZKROCGSYL6NBxvC3W2J9TqmOnyXl2RB1li8aAHqlitb/zQ3C3OsRSGus9j0Qk/5xJkvP8LDjSHQY11qhCMHtG2NrAWHvXTVyQ42olADH09MUkUT+gDIEdShaP2t8hoVBZxjGjsCfLPuAdaY809g==";

/*
    // No me funcionó... RESOLVER!!! para no exponer la clave
   @Value("${jwtSecret}")
   private String SECRET_KEY1;
   
   @Value("${jwtExpiration}")
   private int expiration;
*/

   public String extractUsername(String token) {
      return extractClaim(token, Claims::getSubject);
   }

   public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
      final Claims claims = extractAllClaims(token);
      return claimsResolver.apply(claims);
   }

   public String generateToken(UserDetails userDetails) {
      return generateToken(new HashMap<>(), userDetails);
   }

   public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
      return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact();
   }

   public boolean isTokenValid(String token, UserDetails userDetails) {
      final String username = extractUsername(token);
      return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
   }

   private boolean isTokenExpired(String token) {
      return extractExpiration(token).before(new Date());
   }

   private Date extractExpiration(String token) {
      return extractClaim(token, Claims::getExpiration);
   }

   private Claims extractAllClaims(String token) {
      return Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
   }

   private Key getSignInKey() {
      byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
      return Keys.hmacShaKeyFor(keyBytes);
   }
}
