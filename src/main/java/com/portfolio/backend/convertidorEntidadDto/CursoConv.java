package com.portfolio.backend.convertidorEntidadDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.portfolio.backend.dto.CursoDTO;
import com.portfolio.backend.modelo.Curso;

@Component
public class CursoConv {
   
   public CursoDTO cursoToDto(Curso curso) {

      CursoDTO dto = new CursoDTO();

      dto.setId(curso.getId());
      dto.setTema(curso.getTema());
      dto.setFechaIni(curso.getFechaIni());
      dto.setFechaFin(curso.getFechaFin());

      dto.setEntidad(curso.getEntidad());
      dto.setLogo(curso.getLogo());
      dto.setFullLocalidad(curso.fullLocalidad());

      /* dto.setEntidad(curso.getEntidad().getNombre());
      dto.setLogo(curso.getEntidad().getLogo());
      dto.setLocalidad(curso.getEntidad().getLocalidad().getLocalidad()); */
   
      return dto;
   }

   public List<CursoDTO> listarCursoDto(List<Curso> cursoList) {

      return cursoList.stream().map(x -> cursoToDto(x)).collect(Collectors.toList());
   }

   public Curso dtoToCurso(CursoDTO dto) {

      Curso curso = new Curso();

      curso.setId(dto.getId());
      curso.setTema(dto.getTema());
      curso.setFechaIni(dto.getFechaIni());
      curso.setFechaFin(dto.getFechaFin());
      curso.setEntidad(dto.getEntidad());
      curso.setLogo(dto.getLogo());
      curso.setLocalidad(dto.getFullLocalidad().split(", ")[0]);
      curso.setProvincia(dto.getFullLocalidad().split(", ")[1]);

      
      //curso.setPersona(dto.getPersona());
   
      return curso;  
   }

   public List<Curso> listarDtoCurso(List<CursoDTO> dtoList) {

      return dtoList.stream().map(x -> dtoToCurso(x)).collect(Collectors.toList());      
   }
}