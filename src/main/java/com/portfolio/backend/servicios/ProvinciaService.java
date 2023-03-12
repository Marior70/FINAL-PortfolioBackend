package com.portfolio.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.interfaces.IProvinciaService;
import com.portfolio.backend.modelo.Provincia;
import com.portfolio.backend.repositorio.ProvinciaRepo;

@Service
public class ProvinciaService implements IProvinciaService{

   @Autowired
   public ProvinciaRepo provinciaRepo;

   @Override
   public List<Provincia> obtenerProvincias() {
      return provinciaRepo.findAll();
   }

   @Override
   public void crearProvincia(Provincia pro) {
      provinciaRepo.save(pro);
   }

   @Override
   public void borrarProvincia(Long id) {
      provinciaRepo.deleteById(id);
   }

   @Override
   public Provincia buscarProvincia(Long id) {
      return provinciaRepo.findById(id).orElse(null);
   }

   @Override
   public void editarProvincia(Long id, Provincia pro) {
      provinciaRepo.save(pro);
   }
   
}
