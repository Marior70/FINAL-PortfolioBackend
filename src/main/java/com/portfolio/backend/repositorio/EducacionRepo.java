package com.portfolio.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Educacion;

@Repository
public interface EducacionRepo extends JpaRepository <Educacion,Long>{
   
}
