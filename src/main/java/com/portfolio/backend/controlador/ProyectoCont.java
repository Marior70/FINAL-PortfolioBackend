package com.portfolio.backend.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.portfolio.backend.interfaces.IProyectoService;
import com.portfolio.backend.modelo.Proyecto;
import com.portfolio.backend.convertidorEntidadDto.ProyectoConv;
import com.portfolio.backend.dto.ProyectoDTO;

@RestController
@RequestMapping("/api/proyecto")
@CrossOrigin
public class ProyectoCont {
   @Value("${PathToPNG}")
   private String pathFile;

   @Autowired
   private IProyectoService proyectoServ;
   @Autowired
   private ProyectoConv listProDto;

   @GetMapping("/listar")
   @ResponseBody
   public List<ProyectoDTO> obtenerProyectos() {
      List<Proyecto> pro = proyectoServ.obtenerProyectos();
      return listProDto.listarProyectoDto(pro);
   }

   @GetMapping("/buscar/{id}")
   @ResponseBody
   public Proyecto buscarProyecto(@PathVariable Long id) {
      return proyectoServ.buscarProyecto(id);
   }

   @PostMapping("/nuevo")
   public void crearProyecto(@RequestBody Proyecto pro) {
      pro.setLogo(pathFile + pro.getLogo());
      proyectoServ.crearProyecto(pro);
   }

   @DeleteMapping("/borrar/{id}")
   public void borrarProyecto(@PathVariable Long id) {
      proyectoServ.borrarProyecto(id);
   }
   
   @PutMapping("/editar/{id}")
   public void editarProyecto(@PathVariable("id") Long id, @RequestBody Proyecto pro) {
      pro.setLogo(pathFile + pro.getLogo());
      proyectoServ.editarProyecto(id, pro);
   }

}
