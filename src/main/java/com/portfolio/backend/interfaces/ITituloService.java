package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Titulo;
import java.util.List;

public interface ITituloService {
   public List<Titulo> obtenerTitulos();

   public void crearTitulo(Titulo tit);

   public void borrarTitulo(Long id);

   public Titulo buscarTitulo(Long id);

   public void editarTitulo(Long id, Titulo tit) ;
}
