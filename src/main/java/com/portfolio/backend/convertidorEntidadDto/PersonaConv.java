package com.portfolio.backend.convertidorEntidadDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.portfolio.backend.dto.PersonaDTO;
import com.portfolio.backend.modelo.Persona;

@Component
public class PersonaConv {
   
   public PersonaDTO personaToDto(Persona persona) {

      PersonaDTO dto = new PersonaDTO();

      dto.setId(persona.getId());
      dto.setFullName(persona.fullName());
      dto.setAcercade(persona.getAcercade());
      dto.setFoto(persona.getFoto());
      dto.setEmail(persona.getEmail());
      dto.setMovil(persona.getMovil());
      dto.setResidencia(persona.residencia());      
      dto.setTitulo(persona.getTitulo());

      // dto.setLocalidad(persona.getLocalidad().getLocalidad() + " - " + persona.getLocalidad().getProvincia().getProvincia());
      // dto.setTitulo(persona.getTitulo().getTitulo());
   
      return dto;
   }

   public List<PersonaDTO> listarPersonaDto(List<Persona> personaList) {

      return personaList.stream().map(x -> personaToDto(x)).collect(Collectors.toList());
   }

   public Persona dtoToPersona(PersonaDTO dto) {

      Persona persona = new Persona();

      
      persona.setId(dto.getId());
      persona.setNombres(dto.getFullName());
      persona.setApellidos(dto.getFullName());
      persona.setAcercade(dto.getAcercade());
      persona.setFoto(dto.getFoto());
      persona.setEmail(dto.getEmail());
      persona.setMovil(dto.getMovil());
      
      persona.setLocalidad(dto.getResidencia().split(", ")[0]);
      persona.setProvincia(dto.getResidencia().split(", ")[1]);
      persona.setTitulo(dto.getTitulo());
   
      return persona;  
   }

   public List<Persona> listarDtoPersonas(List<PersonaDTO> dtoList) {

      return dtoList.stream().map(x -> dtoToPersona(x)).collect(Collectors.toList());      
   }

}
