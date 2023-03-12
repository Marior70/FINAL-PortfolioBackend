package com.portfolio.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Curso;


@Repository
public interface CursoRepo extends JpaRepository <Curso,Long>{
   
}
