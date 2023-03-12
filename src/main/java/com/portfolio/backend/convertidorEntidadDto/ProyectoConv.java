package com.portfolio.backend.convertidorEntidadDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.portfolio.backend.dto.ProyectoDTO;
import com.portfolio.backend.modelo.Proyecto;

@Component
public class ProyectoConv {
   
   public ProyectoDTO proyectoToDto(Proyecto proyecto) {

      ProyectoDTO dto = new ProyectoDTO();

      dto.setId(proyecto.getId());
      dto.setNombre(proyecto.getNombre());
      dto.setLogo(proyecto.getLogo());
      dto.setDescripcion(proyecto.getDescripcion());
      dto.setLink(proyecto.getLink());
   
      return dto;
   }

   public List<ProyectoDTO> listarProyectoDto(List<Proyecto> proyectoList) {

      return proyectoList.stream().map(x -> proyectoToDto(x)).collect(Collectors.toList());
   }

   public Proyecto dtoToProyecto(ProyectoDTO dto) {

      Proyecto proyecto = new Proyecto();
      
      proyecto.setId(dto.getId());
      proyecto.setNombre(dto.getNombre());
      proyecto.setLogo(dto.getLogo());
      proyecto.setDescripcion(dto.getDescripcion());
      proyecto.setLink(dto.getLink());
      //proyecto.setPersona(dto.getPersona());
   
      return proyecto;  
   }

   public List<Proyecto> ListarDtoProyecto(List<ProyectoDTO> dtoList) {

      return dtoList.stream().map(x -> dtoToProyecto(x)).collect(Collectors.toList());      
   }
}

