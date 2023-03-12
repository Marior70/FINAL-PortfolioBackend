package com.portfolio.backend.convertidorEntidadDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.portfolio.backend.dto.AptitudDTO;
import com.portfolio.backend.modelo.Aptitud;

@Component
public class AptitudConv {
   
   public AptitudDTO aptitudToDto(Aptitud aptitud) {

      AptitudDTO dto = new AptitudDTO();
      
      dto.setId(aptitud.getId());
      dto.setNombre(aptitud.getNombre());
      dto.setValor(aptitud.getValor());
   
      return dto;
   }

   public List<AptitudDTO> listarAptitudDto(List<Aptitud> aptitudList) {

      return aptitudList.stream().map(x -> aptitudToDto(x)).collect(Collectors.toList());
   }

   public Aptitud dtoToAptitud(AptitudDTO dto) {

      Aptitud aptitud = new Aptitud();

      aptitud.setId(dto.getId());
      aptitud.setNombre(dto.getNombre());
      aptitud.setValor(dto.getValor());
      
      //aptitud.setPersona(dto.getPersona());
   
      return aptitud;  
   }

   public List<Aptitud> listarDtoAptitud(List<AptitudDTO> dtoList) {

      return dtoList.stream().map(x -> dtoToAptitud(x)).collect(Collectors.toList());      
   }
}
