package com.portfolio.backend.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.interfaces.ITituloService;
import com.portfolio.backend.modelo.Titulo;
import com.portfolio.backend.repositorio.TituloRepo;

@Service
public class TituloService implements ITituloService{

   @Autowired
   public TituloRepo tituloRepo;

   @Override
   public List<Titulo> obtenerTitulos() {
      return tituloRepo.findAll();
   }

   @Override
   public void crearTitulo(Titulo tit) {
      tituloRepo.save(tit);
   }

   @Override
   public void borrarTitulo(Long id) {
      tituloRepo.deleteById(id);
   }

   @Override
   public Titulo buscarTitulo(Long id) {
      return tituloRepo.findById(id).orElse(null);
   }

   @Override
   public void editarTitulo(Long id, Titulo titRequest) {
      Titulo tit =  tituloRepo.findById(id).orElseThrow(null);
      tit.setId(id);
      tit.setNombre(titRequest.getNombre());
      
      tituloRepo.save(tit);
   }

}
