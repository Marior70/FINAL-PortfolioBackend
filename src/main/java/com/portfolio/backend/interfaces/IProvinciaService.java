package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Provincia;
import java.util.List;

public interface IProvinciaService {
   public List<Provincia> obtenerProvincias();

   public void crearProvincia(Provincia prov);

   public void borrarProvincia(Long id);

   public Provincia buscarProvincia(Long id);

   public void editarProvincia(Long id, Provincia prov);
}
