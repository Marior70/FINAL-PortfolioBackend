package com.portfolio.backend.servicios;

// import com.portfolio.backend.conversionEntidadDto.CursoConv;
import com.portfolio.backend.modelo.Curso;
import com.portfolio.backend.interfaces.ICursoService;
import com.portfolio.backend.repositorio.CursoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService {

   @Autowired
   public CursoRepo cursoRepo;
   
   @Override
   public List<Curso> obtenerCursos() {
      return cursoRepo.findAll();      
   }

   @Override
   public void crearCurso(Curso cur) {      
      cursoRepo.save(cur);
   }

   @Override
   public void borrarCurso(Long id) {
      cursoRepo.deleteById(id);
   }

   @Override
   public Curso buscarCurso(Long id) {
      return cursoRepo.findById(id).orElse(null);
   }

   @Override
   public void editarCurso(Long id, Curso curRequest) {
      Curso cur = cursoRepo.findById(id).orElseThrow(null);
      cur.setTema(curRequest.getTema());
      cur.setFechaIni(curRequest.getFechaIni());
      cur.setFechaFin(curRequest.getFechaFin());
      cur.setEntidad(curRequest.getEntidad());
      cur.setLogo(curRequest.getLogo());
      cur.setLocalidad(curRequest.getLocalidad());
      cur.setProvincia(curRequest.getProvincia());      
      
      cursoRepo.save(cur);
   }

}
