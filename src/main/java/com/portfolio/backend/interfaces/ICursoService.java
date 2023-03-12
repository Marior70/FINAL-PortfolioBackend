package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Curso;
import java.util.List;

public interface ICursoService {
   public List<Curso> obtenerCursos();

   public void crearCurso(Curso Cur);

   public void borrarCurso(Long id);

   public Curso buscarCurso(Long id);

   public void editarCurso(Long id, Curso Cur);
}
