package com.portfolio.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.portfolio.backend.interfaces.IAptitudService;
import com.portfolio.backend.modelo.Aptitud;
import com.portfolio.backend.convertidorEntidadDto.AptitudConv;
import com.portfolio.backend.dto.AptitudDTO;

@RestController
@RequestMapping("/api/aptitud")
@CrossOrigin
public class AptitudCont {

   @Autowired
   private IAptitudService aptitudServ;
   @Autowired
   private AptitudConv listAptDto;

   @GetMapping("/listar")
   @PreAuthorize("hasAuthority('ROLE_USER')")
   @ResponseBody
   public List<AptitudDTO> obtenerAptitudes() {
      List<Aptitud> apt = aptitudServ.obtenerAptitudes();
      return listAptDto.listarAptitudDto(apt);
   }

   @GetMapping("/buscar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   @ResponseBody
   public Aptitud buscarAptitud(@PathVariable Long id) {
      return aptitudServ.buscarAptitud(id);
   }

   @PostMapping("/nueva")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void crearAptitud(@RequestBody Aptitud apt) {
      aptitudServ.crearAptitud(apt);
   }

   @DeleteMapping("/borrar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void borrarAptitud(@PathVariable Long id) {
      aptitudServ.borrarAptitud(id);
   }

   @PutMapping("editar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void editarAptitud(@PathVariable("id") Long id, @RequestBody Aptitud apt) {
      aptitudServ.editarAptitud(id, apt);
   }

}