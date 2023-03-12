package com.portfolio.backend.modelo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
   
   private List<Persona> persona;
   private List<Experiencia> experiencias;
   private List<Educacion> educacion;
   private List<Curso> cursos;
   private List<Aptitud> aptitudes;
   private List<Proyecto> proyectos;
}
