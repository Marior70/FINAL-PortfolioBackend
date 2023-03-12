package com.portfolio.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.interfaces.IEntidadService;
import com.portfolio.backend.modelo.Entidad;
import com.portfolio.backend.repositorio.EntidadRepo;

@Service
public class EntidadService implements IEntidadService{

   @Autowired
   public EntidadRepo entidadRepo;

   @Override
   public List<Entidad> obtenerEntidades() {
      return entidadRepo.findAll();
   }

   @Override
   public void crearEntidad(Entidad ent) {
      entidadRepo.save(ent);
   }

   @Override
   public void borrarEntidad(Long id) {
      entidadRepo.deleteById(id);
   }

   @Override
   public Entidad buscarEntidad(Long id) {
      return entidadRepo.findById(id).orElse(null);
   }

   @Override
   public void editarEntidad(Long id, Entidad ent){
      entidadRepo.save(ent);
   };
}
