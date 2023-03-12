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

import com.portfolio.backend.interfaces.IEducacionService;
import com.portfolio.backend.modelo.Educacion;
import com.portfolio.backend.convertidorEntidadDto.EducacionConv;
import com.portfolio.backend.dto.EducacionDTO;

@RestController
@RequestMapping("/api/educacion")
@CrossOrigin
public class EducacionCont {
   @Value("${PathToPNG}")
   private String pathFile;

   @Autowired
   private IEducacionService educacionServ;
   @Autowired
   private EducacionConv listEduDto;

   @GetMapping("/listar")
   @ResponseBody
   public List<EducacionDTO> obtenerEducacion() {
      List<Educacion> edu = educacionServ.obtenerEducacion();
      return listEduDto.listarEducacionDto(edu);
   }

   @GetMapping("/buscar/{id}")
   @ResponseBody
   public Educacion buscarEducacion(@PathVariable Long id) {
      return educacionServ.buscarEducacion(id);
   }

   @PostMapping("/nueva")
   public void crearEducacion(@RequestBody Educacion edu) {
      edu.setLogo(pathFile + edu.getLogo());
      educacionServ.crearEducacion(edu);
   }

   @DeleteMapping("/borrar/{id}")
   public void borrarEducacion(@PathVariable Long id) {
      educacionServ.borrarEducacion(id);
   }
   
   @PutMapping("/editar/{id}")
   public void editarEducacion(@PathVariable("id") Long id, @RequestBody Educacion edu) {
      edu.setLogo(pathFile + edu.getLogo());
      educacionServ.editarEducacion(id, edu);
   }

}
