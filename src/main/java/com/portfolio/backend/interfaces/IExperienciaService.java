package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Experiencia;
import java.util.List;

public interface IExperienciaService {
   public List<Experiencia> obtenerExperiencias();

   public void crearExperiencia(Experiencia exp);

   public void borrarExperiencia(Long id);

   public Experiencia buscarExperiencia(Long id);

   public void editarExperiencia(Long id, Experiencia exp);
}
