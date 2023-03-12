package com.portfolio.backend.convertidorEntidadDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.portfolio.backend.dto.EducacionDTO;
import com.portfolio.backend.modelo.Educacion;

@Component
public class EducacionConv {
   
   public EducacionDTO educacionToDto(Educacion educacion) {

      EducacionDTO dto = new EducacionDTO();

      dto.setId(educacion.getId());
      dto.setNivel(educacion.getNivel());
      dto.setEstado(educacion.getEstado());
      dto.setFechaIni(educacion.getFechaIni());
      dto.setFechaFin(educacion.getFechaFin());

      dto.setTitulo(educacion.getTitulo());
      dto.setEntidad(educacion.getEntidad());
      dto.setLogo(educacion.getLogo());
      dto.setFullLocalidad(educacion.fullLocalidad());

      /* dto.setTitulo(educacion.getTitulo().getTitulo());
      dto.setEntidad(educacion.getEntidad().getNombre());
      dto.setLogo(educacion.getEntidad().getLogo());
      dto.setLocalidad(educacion.getEntidad().getLocalidad().getLocalidad()); */
   
      return dto;
   }

   public List<EducacionDTO> listarEducacionDto(List<Educacion> educacionList) {

      return educacionList.stream().map(x -> educacionToDto(x)).collect(Collectors.toList());
   }

   public Educacion dtoToEducacion(EducacionDTO dto) {

      Educacion educacion = new Educacion();
      
      educacion.setId(dto.getId());
      educacion.setNivel(dto.getNivel());
      educacion.setEstado(dto.getEstado());
      educacion.setFechaIni(dto.getFechaIni());
      educacion.setFechaFin(dto.getFechaFin());

      educacion.setTitulo(dto.getTitulo());
      educacion.setEntidad(dto.getEntidad());
      educacion.setLogo(dto.getLogo());
      educacion.setLocalidad(dto.getFullLocalidad().split(", ")[0]);
      educacion.setProvincia(dto.getFullLocalidad().split(", ")[1]);
      
      //educacion.setPersona(dto.getPersona().);
   
      return educacion;  
   }

   public List<Educacion> listarDtoEducacion(List<EducacionDTO> dtoList) {

      return dtoList.stream().map(x -> dtoToEducacion(x)).collect(Collectors.toList());      
   }
}
