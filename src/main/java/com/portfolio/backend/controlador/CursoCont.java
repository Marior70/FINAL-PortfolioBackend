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

import com.portfolio.backend.interfaces.ICursoService;
import com.portfolio.backend.modelo.Curso;
import com.portfolio.backend.convertidorEntidadDto.CursoConv;
import com.portfolio.backend.dto.CursoDTO;

@RestController
@RequestMapping("/api/curso")
@CrossOrigin
public class CursoCont {
   
   @Value("${PathToPNG}")
   private String pathFile;

   @Autowired
   private ICursoService cursoServ;
   @Autowired
   private CursoConv listCurDto;

   @GetMapping("/listar")
   @ResponseBody
   public List<CursoDTO> obtenerCursos() {
      List<Curso> cur = cursoServ.obtenerCursos();
      return listCurDto.listarCursoDto(cur);
   }

   @GetMapping("/buscar/{id}")
   @ResponseBody
   public Curso buscarCurso(@PathVariable Long id) {
      return cursoServ.buscarCurso(id);
   }

   @PostMapping("/nuevo")
   public void crearCurso(@RequestBody Curso cur) {
      cur.setLogo(pathFile + cur.getLogo());
      cursoServ.crearCurso(cur);
   }

   @DeleteMapping("/borrar/{id}")
   public void borrarCurso(@PathVariable Long id) {
      cursoServ.borrarCurso(id);
   }
   
   @PutMapping("/editar/{id}")
   public void editarCurso(@PathVariable("id") Long id, @RequestBody Curso cur) {
      cur.setLogo(pathFile + cur.getLogo());
      cursoServ.editarCurso(id, cur);
   }

}
