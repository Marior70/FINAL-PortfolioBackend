package com.portfolio.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.interfaces.IPersonaService;
import com.portfolio.backend.modelo.Persona;
import com.portfolio.backend.convertidorEntidadDto.PersonaConv;
import com.portfolio.backend.dto.PersonaDTO;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin
public class PersonaCont {
   @Value("${PathToPNG}")
   private String pathFile;

   @Autowired
   private IPersonaService personaServ;
   @Autowired
   private PersonaConv listPerDto;

   @GetMapping("/listar")
   @PreAuthorize("hasAuthority('ROLE_USER')")
   @ResponseBody
   public List<PersonaDTO> obtenerPersonas() {
      List<Persona> per = personaServ.obtenerPersonas();      
      return listPerDto.listarPersonaDto(per);
   }

   /* @GetMapping("/listar")
   @PreAuthorize("hasAuthority('ROLE_USER')")
   @ResponseBody
   public List<Persona> obtenerPersonas() {
      return personaServ.obtenerPersonas();
   } */

   @GetMapping("/buscar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   @ResponseBody
   public Persona buscarPersona(@PathVariable Long id) {
      return personaServ.buscarPersona(id);
   }

   @PostMapping("/nueva")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void crearPersona(@RequestBody Persona per) {
      per.setFoto(pathFile + per.getFoto());
      personaServ.crearPersona(per);
   }

   @DeleteMapping("/borrar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void borrarPersona(@PathVariable Long id) {
      personaServ.borrarPersona(id);
   }

   @PutMapping("/editar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void editarPersona(@PathVariable("id") Long id, @RequestBody Persona per) {
      per.setFoto(pathFile + per.getFoto());
      personaServ.editarPersona(id, per);
   }

}
