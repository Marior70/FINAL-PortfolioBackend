package com.portfolio.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Experiencia;

@Repository
public interface ExperienciaRepo extends JpaRepository <Experiencia,Long>{
   
}
