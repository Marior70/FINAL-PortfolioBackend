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

import com.portfolio.backend.interfaces.ITituloService;
import com.portfolio.backend.modelo.Titulo;

@RestController
@RequestMapping("/api/titulo")
@CrossOrigin
public class TituloCont {

   @Autowired
   private ITituloService tituloServ;

   @GetMapping("/listar")
   @ResponseBody
   public List<Titulo> obtenerTitulos() {
      return tituloServ.obtenerTitulos();
   }

   @GetMapping("/buscar/{id}")
   @ResponseBody
   public Titulo buscarTitulo(@PathVariable Long id) {
      return tituloServ.buscarTitulo(id);
   }

   @PostMapping("/nuevo")
   public void agregarTitulo(@RequestBody Titulo tit) {
      // listaTitulos.add(tit);
      tituloServ.crearTitulo(tit);
   }

   @DeleteMapping("/borrar/{id}")
   public void borrarTitulo(@PathVariable Long id) {
      tituloServ.borrarTitulo(id);
   }

   @PutMapping("/editar/{id}")
   public void editarTitulo(@PathVariable("id") Long id, @RequestBody Titulo tit) {
      tituloServ.editarTitulo(id, tit);
   }

}
