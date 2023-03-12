package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Proyecto;
import java.util.List;

public interface IProyectoService {
   public List<Proyecto> obtenerProyectos();

   public void crearProyecto(Proyecto pro);

   public void borrarProyecto(Long id);

   public Proyecto buscarProyecto(Long id);

   public void editarProyecto(Long id, Proyecto pro);
}
