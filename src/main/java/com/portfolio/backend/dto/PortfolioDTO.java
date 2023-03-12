package com.portfolio.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class PortfolioDTO {
   
   private List<PersonaDTO> persona;
   private List<ExperienciaDTO> experiencias;
   private List<EducacionDTO> educacion;
   private List<CursoDTO> cursos;
   // private List<AptitudDTO> aptitudes;
   private List<ProyectoDTO> proyectos;
}
