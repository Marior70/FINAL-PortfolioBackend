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

import com.portfolio.backend.interfaces.ILocalidadService;
import com.portfolio.backend.modelo.Localidad;

@RestController
@RequestMapping("/api/localidad")
@CrossOrigin
public class LocalidadCont {

   @Autowired
   private ILocalidadService localidadServ;

   @GetMapping("/listar")
   @PreAuthorize("hasAuthority('ROLE_USER')")
   @ResponseBody
   public List<Localidad> obtenerLocalidades() {
      return localidadServ.obtenerLocalidades();
   }

   @GetMapping("/buscar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   @ResponseBody
   public Localidad buscarLocalidad(@PathVariable Long id) {
      return localidadServ.buscarLocalidad(id);
   }

   @PostMapping("/nueva")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void crearLocalidad(@RequestBody Localidad loc) {
      // listaLocalidades.add(loc);
      localidadServ.crearLocalidad(loc);
   }

   @DeleteMapping("/borrar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void borrarLocalidad(@PathVariable Long id) {
      localidadServ.borrarLocalidad(id);
   }

   @PutMapping("/editar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void editarLocalidad(@PathVariable("id") Long id, @RequestBody Localidad loc) {
      localidadServ.editarLocalidad(id, loc);
   }

}
