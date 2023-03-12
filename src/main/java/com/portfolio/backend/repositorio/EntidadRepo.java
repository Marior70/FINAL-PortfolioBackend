package com.portfolio.backend.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Entidad;

@Repository
public interface EntidadRepo extends JpaRepository <Entidad,Long>{
   
   Optional<Entidad> findOneByNombre(String nombre);
   
}
