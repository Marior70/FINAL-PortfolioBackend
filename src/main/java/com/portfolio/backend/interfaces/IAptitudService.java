package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Aptitud;
import java.util.List;

public interface IAptitudService {
   public List<Aptitud> obtenerAptitudes();

   public void crearAptitud(Aptitud apt);

   public void borrarAptitud(Long id);

   public Aptitud buscarAptitud(Long id);

   public void editarAptitud(Long id, Aptitud apt);
}
