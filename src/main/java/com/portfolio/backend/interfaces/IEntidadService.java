package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Entidad;
import java.util.List;

public interface IEntidadService {
   public List<Entidad> obtenerEntidades();

   public void crearEntidad(Entidad ent);

   public void borrarEntidad(Long id);

   public Entidad buscarEntidad(Long id);
   
   public void editarEntidad(Long id, Entidad ent);
}
