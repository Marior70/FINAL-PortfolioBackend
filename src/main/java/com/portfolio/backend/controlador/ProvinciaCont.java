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

import com.portfolio.backend.interfaces.IProvinciaService;
import com.portfolio.backend.modelo.Provincia;

@RestController
@RequestMapping("/api/provincia")
@CrossOrigin
public class ProvinciaCont {

   @Autowired
   private IProvinciaService provinciaServ;

   @GetMapping("/listar")
   @PreAuthorize("hasAuthority('ROLE_USER')")
   @ResponseBody
   public List<Provincia> obtenerProvincias() {
      return provinciaServ.obtenerProvincias();
   }

   @GetMapping("/buscar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   @ResponseBody
   public Provincia buscarProvincia(@PathVariable Long id) {
      return provinciaServ.buscarProvincia(id);
   }

   @PostMapping("/nueva")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void crearProvincia(@RequestBody Provincia prov) {
      provinciaServ.crearProvincia(prov);
   }

   @DeleteMapping("/borrar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void borrarProvincia(@PathVariable Long id) {
      provinciaServ.borrarProvincia(id);
   }
   
   @PutMapping("/editar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void editarProvincia(@PathVariable("id") Long id, @RequestBody Provincia prov) {
      provinciaServ.editarProvincia(id, prov);
   }

}
