package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Educacion;
import java.util.List;

public interface IEducacionService {
   public List<Educacion> obtenerEducacion();

   public void crearEducacion(Educacion edu);

   public void borrarEducacion(Long id);

   public Educacion buscarEducacion(Long id);

   public void editarEducacion(Long id, Educacion edu);
}
