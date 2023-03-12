package com.portfolio.backend.seguridad.usuarios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository <Usuario, Long>{
   
   Optional<Usuario> findOneByUsername(String username);
   // Boolean existsByUsername(String username);
   // Boolean existsByEmail(String email);

}
