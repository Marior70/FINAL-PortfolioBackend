package com.portfolio.backend.convertidorEntidadDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.portfolio.backend.dto.ExperienciaDTO;
import com.portfolio.backend.modelo.Experiencia;

@Component
public class ExperienciaConv {
   
   public ExperienciaDTO experienciaToDto(Experiencia experiencia) {

      ExperienciaDTO dto = new ExperienciaDTO();
      dto.setId(experiencia.getId());
      dto.setRol(experiencia.getRol());
      dto.setFechaIni(experiencia.getFechaIni());
      dto.setFechaFin(experiencia.getFechaFin());
      dto.setDescripcion(experiencia.getDescripcion());

      dto.setEntidad(experiencia.getEntidad());
      dto.setLogo(experiencia.getLogo());
      
      /* dto.setEntidad(experiencia.getEntidad().getNombre());
      dto.setLogo(experiencia.getEntidad().getLogo()); */
   
      return dto;
   }

   public List<ExperienciaDTO> listarExperienciaDto(List<Experiencia> experienciaList) {

      return experienciaList.stream().map(x -> experienciaToDto(x)).collect(Collectors.toList());
   }

   public Experiencia dtoToExperiencia(ExperienciaDTO dto) {

      Experiencia experiencia = new Experiencia();
      experiencia.setId(dto.getId());
      experiencia.setRol(dto.getRol());
      experiencia.setFechaIni(dto.getFechaIni());
      experiencia.setFechaFin(dto.getFechaFin());
      experiencia.setDescripcion(dto.getDescripcion());
      
      experiencia.setEntidad(dto.getEntidad());
      experiencia.setLogo(dto.getLogo());

      //experiencia.setPersona(dto.getPersona());
   
      return experiencia;  
   }

   public List<Experiencia> listarDtoExperiencia(List<ExperienciaDTO> dtoList) {

      return dtoList.stream().map(x -> dtoToExperiencia(x)).collect(Collectors.toList());      
   }
}
