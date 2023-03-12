package com.portfolio.backend.seguridad.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.backend.seguridad.usuarios.Usuario;
import com.portfolio.backend.seguridad.usuarios.UsuarioRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

   @Autowired
   private UsuarioRepo usrRepo;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Usuario usuario = usrRepo
         .findOneByUsername(username)
         .orElseThrow(() -> new UsernameNotFoundException("El username " + username + " no existe"));

return new UserDetailsImpl(usuario);
   }

}
