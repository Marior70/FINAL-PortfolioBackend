package com.portfolio.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.portfolio.backend.interfaces.IEntidadService;
import com.portfolio.backend.modelo.Entidad;

@RestController
@RequestMapping("/api/entidad")
@CrossOrigin
public class EntidadCont {
   String pathFile = "./assest/img";
   
   @Autowired
   private IEntidadService entidadServ;

   @GetMapping("/listar")
   @ResponseBody
   public List<Entidad> obtenerEntidades() {
      return entidadServ.obtenerEntidades();
   }

   @GetMapping("/buscar/{id}")
   @ResponseBody
   public Entidad buscarEntidad(@PathVariable Long id) {
      return entidadServ.buscarEntidad(id);
   }

   @PostMapping("/nueva")
   public void crearEntidad(@RequestBody Entidad ent) {
      entidadServ.crearEntidad(ent);
   }

   @DeleteMapping("/borrar/{id}")
   public void borrarEntidad(@PathVariable Long id) {
      entidadServ.borrarEntidad(id);
   }

   @PutMapping("/editar/{id}")
   public void editarEntidad(@PathVariable("id") Long id, @RequestBody Entidad ent) {
      ent.setLogo(pathFile + ent.getLogo());
      entidadServ.editarEntidad(id, ent);
   }

}
