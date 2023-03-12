package com.portfolio.backend.seguridad.roles;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolService {
   @Autowired
    RolRepo rolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepo.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepo.save(rol);
    }
}
