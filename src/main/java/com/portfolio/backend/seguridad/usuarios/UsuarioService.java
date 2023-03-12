package com.portfolio.backend.seguridad.usuarios;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// import com.portfolio.backend.seguridad.usuarios.IUsuarioService;
import com.portfolio.backend.seguridad.roles.Rol;
// import com.portfolio.backend.seguridad.usuarios.Usuario;
import com.portfolio.backend.seguridad.roles.RolRepo;
// import com.portfolio.backend.seguridad.usuarios.UsuarioRepo;
import com.portfolio.backend.seguridad.roles.RolNombre;
import com.portfolio.backend.seguridad.roles.RolService;

@Service
public class UsuarioService implements IUsuarioService{

   @Autowired
   public UsuarioRepo usuarioRepo;
   @Autowired
   public RolRepo rolRepo;
   @Autowired
   public RolService rolService;

   @Override
   public List<Usuario> obtenerUsuarios() {
      return usuarioRepo.findAll();
   }

   @Override
   public void crearUsuario(Usuario usr) {
      usr.setPassword(new BCryptPasswordEncoder().encode(usr.getPassword()));

      Set<Rol> roles = new HashSet<>();
      roles.add(rolService.getByRolNombre(RolNombre.ROL_USER).get());
      usr.setRoles(roles);

      usuarioRepo.save(usr);
   }

   @Override
   public void borrarUsuario(Long id) {
      usuarioRepo.deleteById(id);     
   }

   @Override
   public Usuario buscarUsuario(Long id) {
      return usuarioRepo.findById(id).orElse(null);
   }

   @Override
   public void editarUsuario(Long id, Usuario usrRequest){
      Usuario usr = usuarioRepo.findById(id).orElseThrow(null);
      usr.setId(usrRequest.getId());
      usr.setName(usrRequest.getName());
      usr.setEmail(usrRequest.getEmail());
      usr.setPassword(new BCryptPasswordEncoder().encode(usrRequest.getPassword()));
      usr.setEntidad(usrRequest.getEntidad());
      
      usuarioRepo.save(usr);
   }
   
}