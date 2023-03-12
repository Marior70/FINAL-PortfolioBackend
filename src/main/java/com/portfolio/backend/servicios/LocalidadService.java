package com.portfolio.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.interfaces.ILocalidadService;
import com.portfolio.backend.modelo.Localidad;
import com.portfolio.backend.repositorio.LocalidadRepo;

@Service
public class LocalidadService implements ILocalidadService{

   @Autowired
   public LocalidadRepo localidadRepo;

   @Override
   public List<Localidad> obtenerLocalidades() {
      return localidadRepo.findAll();
   }

   @Override
   public void crearLocalidad(Localidad loc) {
      localidadRepo.save(loc);
   }

   @Override
   public void borrarLocalidad(Long id) {
      localidadRepo.deleteById(id);
   }

   @Override
   public Localidad buscarLocalidad(Long id) {
      return localidadRepo.findById(id).orElse(null);
   }

   @Override
   public void editarLocalidad(Long id, Localidad locRequest){
      Localidad loc = localidadRepo.findById(id).orElseThrow(null);
      loc.setId(id);
      loc.setNombre(locRequest.getNombre());

      localidadRepo.save(loc);
   }
   
}
