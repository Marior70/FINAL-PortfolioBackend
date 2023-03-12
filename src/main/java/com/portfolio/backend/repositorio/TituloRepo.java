package com.portfolio.backend.repositorio;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Titulo;

@Repository
public interface TituloRepo extends JpaRepository <Titulo,Long>{

   // Optional<Titulo> findOneByNombre(String nombre);
   
}
