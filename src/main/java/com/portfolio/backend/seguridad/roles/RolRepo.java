package com.portfolio.backend.seguridad.roles;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepo extends JpaRepository<Rol, Integer> {
   Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
