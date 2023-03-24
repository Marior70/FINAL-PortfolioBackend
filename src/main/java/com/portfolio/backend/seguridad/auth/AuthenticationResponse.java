package com.portfolio.backend.seguridad.auth;

import com.portfolio.backend.seguridad.user.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  private String tokenType;
  private Role rol;
}
