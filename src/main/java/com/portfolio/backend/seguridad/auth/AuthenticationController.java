package com.portfolio.backend.seguridad.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin 
public class AuthenticationController {

   private final AuthenticationService service;

   @PostMapping("/registrar")
   public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
      return ResponseEntity.ok(service.register(request));
   }

   @PostMapping("/abrirportfolio")
   public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
      return ResponseEntity.ok(service.authenticate(request));
   }

}
