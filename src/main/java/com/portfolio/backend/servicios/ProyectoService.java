package com.portfolio.backend.servicios;

import com.portfolio.backend.interfaces.IProyectoService;
import com.portfolio.backend.modelo.Proyecto;
import com.portfolio.backend.repositorio.ProyectoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService implements IProyectoService {

   @Autowired
   public ProyectoRepo proyectoRepo;

   @Override
   public List<Proyecto> obtenerProyectos() {
      return proyectoRepo.findAll();
   }

   @Override
   public void crearProyecto(Proyecto pro) {
      proyectoRepo.save(pro);
   }

   @Override
   public void borrarProyecto(Long id) {
      proyectoRepo.deleteById(id);
   }

   @Override
   public Proyecto buscarProyecto(Long id) {
      return proyectoRepo.findById(id).orElse(null);
   }

   @Override
   public void editarProyecto(Long id, Proyecto proRequest) {
      Proyecto pro = proyectoRepo.findById(id).orElseThrow(null);
      pro.setId(id);
      pro.setNombre(proRequest.getNombre());
      pro.setLogo(proRequest.getLogo());
      pro.setDescripcion(proRequest.getDescripcion());
      pro.setLink(proRequest.getLink());
            
      proyectoRepo.save(pro);
   }

}
