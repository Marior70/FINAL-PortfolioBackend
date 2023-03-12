package com.portfolio.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.modelo.Aptitud;

@Repository
public interface AptitudRepo extends JpaRepository <Aptitud,Long>{
   
}
