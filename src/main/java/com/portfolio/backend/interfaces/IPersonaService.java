package com.portfolio.backend.interfaces;

import com.portfolio.backend.modelo.Persona;
import java.util.List;

public interface IPersonaService {
   public List<Persona> obtenerPersonas();

   // public void crearPersona(Persona per);

   // public void borrarPersona(Long id);

   // public Persona buscarPersona(Long id);

   public void editarPersona(Long id, Persona per);
}
