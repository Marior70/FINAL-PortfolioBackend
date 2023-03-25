package com.portfolio.backend.servicios;

import com.portfolio.backend.interfaces.IPersonaService;
import com.portfolio.backend.modelo.Persona;
// import com.portfolio.backend.repositorio.LocalidadRepo;
import com.portfolio.backend.repositorio.PersonaRepo;
// import com.portfolio.backend.repositorio.TituloRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
   
   // Boolean  existeLocalidad = false;
   // Boolean existeTitulo = false;

   @Autowired
   public PersonaRepo personaRepo;
   // @Autowired
   // public LocalidadRepo localidadRepo;   
   // @Autowired
   // public TituloRepo tituloRepo;

   @Override
   public List<Persona> obtenerPersonas() {
      return personaRepo.findAll();
   }

   /* @Override
   public void crearPersona(Persona per) {
      personaRepo.save(per);
   } */

   /* @Override
   public void borrarPersona(Long id) {
      personaRepo.deleteById(id); 
   } */

   /* @Override
   public Persona buscarPersona(Long id) {
      Persona per = personaRepo.findById(id).orElseThrow(null);
      return per;
   } */

   @Override
   public void editarPersona(Long id, Persona perRequest) {      
      Persona per = personaRepo.findById(id).orElseThrow(null);      
      per.setNombres(perRequest.getNombres());
      per.setApellidos(perRequest.getApellidos());
      per.setAcercade(perRequest.getAcercade());
      per.setFoto(perRequest.getFoto());
      per.setEmail(perRequest.getEmail());
      per.setMovil(perRequest.getMovil());
      per.setLocalidad(perRequest.getLocalidad());
      per.setProvincia(perRequest.getProvincia());
      per.setTitulo(perRequest.getTitulo());

   /*    
      List<Localidad> listLocalidad = localidadRepo.findAll();
      listLocalidad.forEach((loc) -> {
         if (loc.getNombre() == perRequest.getLocalidad().getNombre()) {
            existeLocalidad = true;
            per.setLocalidad(loc);
         }
      });

      if (!existeLocalidad) {
         Localidad localidad = new Localidad();
         localidad.setNombre(perRequest.getLocalidad().getNombre());
         localidad.setProvincia(perRequest.getLocalidad().getProvincia()); // acá debo preveer en el Fronend, mostrar todas las provincias para seleccionar la localidad, ya que en la bd están ingresadas todas las provincias.

         per.setLocalidad(localidad);
      }      
            
      List<Titulo> listTitulo = tituloRepo.findAll();
      listTitulo.forEach((tit) -> {
      if (tit.getNombre() == perRequest.getTitulo().getNombre()) {
      per.setTitulo(tit);
      existeTitulo = true;
      }
      });
      if (!existeTitulo) {
         Titulo titulo = new Titulo();
         titulo.setNombre(perRequest.getTitulo().getNombre());
         tituloRepo.save(titulo);
         Titulo tit = tituloRepo.findOneByNombre(titulo.getNombre());
         per.setTitulo(tit);
      }      
   */
     
      personaRepo.save(per);      
   }

}
