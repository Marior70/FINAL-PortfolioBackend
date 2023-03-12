package com.portfolio.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Proyecto;

@Repository
public interface ProyectoRepo extends JpaRepository <Proyecto,Long>{
   
}
