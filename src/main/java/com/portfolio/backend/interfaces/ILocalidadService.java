package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Localidad;
import java.util.List;

public interface ILocalidadService {
   public List<Localidad> obtenerLocalidades();
   
   public void crearLocalidad(Localidad loc);

   public void borrarLocalidad(Long id);   

   public Localidad buscarLocalidad(Long id);
   
   public void editarLocalidad(Long id, Localidad loc);
}
