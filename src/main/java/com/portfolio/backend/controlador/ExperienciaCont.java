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

import com.portfolio.backend.interfaces.IExperienciaService;
import com.portfolio.backend.modelo.Experiencia;
import com.portfolio.backend.convertidorEntidadDto.ExperienciaConv;
import com.portfolio.backend.dto.ExperienciaDTO;

@RestController
@RequestMapping("/api/experiencia")
@CrossOrigin
public class ExperienciaCont {
   @Value("${PathToPNG}")
   private String pathFile;

   @Autowired
   private IExperienciaService experienciaServ;
   @Autowired
   private ExperienciaConv listExpDto;

   @GetMapping("/listar")
   @PreAuthorize("hasAuthority('ROLE_USER')")
   @ResponseBody
   public List<ExperienciaDTO> obtenerExperiencias() {
      List<Experiencia> per = experienciaServ.obtenerExperiencias();
      return listExpDto.listarExperienciaDto(per);
   }

   @GetMapping("/buscar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   @ResponseBody
   public Experiencia buscarExperiencia(@PathVariable Long id) {
      return experienciaServ.buscarExperiencia(id);
   }

   @PostMapping("/nueva")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void crearExperiencia(@RequestBody Experiencia exp) {
      exp.setLogo(pathFile + exp.getLogo());
      experienciaServ.crearExperiencia(exp);
   }

   @DeleteMapping("/borrar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void borrarExperiencia(@PathVariable Long id) {
      experienciaServ.borrarExperiencia(id);
   }
   
   @PutMapping("/editar/{id}")
   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
   public void editarExperiencia(@PathVariable("id") Long id, @RequestBody Experiencia exp) {
      exp.setLogo(pathFile + exp.getLogo());
      experienciaServ.editarExperiencia(id, exp);
   }   

}
