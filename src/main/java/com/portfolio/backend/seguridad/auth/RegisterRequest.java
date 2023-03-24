package com.portfolio.backend.seguridad.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String name; //firstname;
  private String username; //lastname;
  private String email;
  private String password;
  private String entidad;
}
