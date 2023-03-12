package com.portfolio.backend.servicios;

import com.portfolio.backend.interfaces.IEducacionService;
import com.portfolio.backend.modelo.Educacion;
import com.portfolio.backend.repositorio.EducacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionService implements IEducacionService{

   @Autowired
   public EducacionRepo educacionRepo;
   
   @Override
   public List<Educacion> obtenerEducacion(){
      return educacionRepo.findAll();      
   }
      
   @Override
   public void crearEducacion(Educacion edu) {
      educacionRepo.save(edu);
   }

   @Override
   public void borrarEducacion(Long id) {      
      educacionRepo.deleteById(id);
   }

   @Override
   public Educacion buscarEducacion(Long id) {      
      return educacionRepo.findById(id).orElse(null);
   }

   @Override
   public void editarEducacion(Long id, Educacion eduRequest){
      Educacion edu = educacionRepo.findById(id).orElseThrow(null);
      edu.setId(eduRequest.getId());
      edu.setNivel(eduRequest.getNivel());
      edu.setEstado(eduRequest.getEstado());
      edu.setFechaIni(eduRequest.getFechaIni());
      edu.setFechaFin(eduRequest.getFechaFin());
      edu.setTitulo(eduRequest.getTitulo());
      edu.setEntidad(eduRequest.getEntidad());
      edu.setLogo(eduRequest.getLogo());
      edu.setLocalidad(eduRequest.getLocalidad());
      edu.setProvincia(eduRequest.getProvincia());

      educacionRepo.save(edu);
   }

}

   

   
   







