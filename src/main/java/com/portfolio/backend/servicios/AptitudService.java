package com.portfolio.backend.servicios;

import com.portfolio.backend.interfaces.IAptitudService;
import com.portfolio.backend.modelo.Aptitud;
import com.portfolio.backend.repositorio.AptitudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AptitudService implements IAptitudService{

   @Autowired
   public AptitudRepo aptitudRepo;
  
   @Override
   public List<Aptitud> obtenerAptitudes(){
      return aptitudRepo.findAll();
   }
      
   @Override
   public void crearAptitud(Aptitud apt) {
      aptitudRepo.save(apt);
   }

   @Override
   public void borrarAptitud(Long id) {
      aptitudRepo.deleteById(id);
   }

   @Override
   public Aptitud buscarAptitud(Long id) {
      return aptitudRepo.findById(id).orElse(null);      
   }

   @Override
   public void editarAptitud(Long id, Aptitud aptRequest){
      Aptitud apt = aptitudRepo.findById(id).orElseThrow(null);
      apt.setId(aptRequest.getId());
      apt.setNombre(aptRequest.getNombre());
      apt.setValor(aptRequest.getValor());
      
      aptitudRepo.save(apt);
   }

}

   

   
   







