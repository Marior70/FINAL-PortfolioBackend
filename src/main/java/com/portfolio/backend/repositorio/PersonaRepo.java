package com.portfolio.backend.repositorio;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Persona;

@Repository
public interface PersonaRepo extends JpaRepository <Persona,Long>{

   //Optional<Persona> findOneById(Long id);
      
}
