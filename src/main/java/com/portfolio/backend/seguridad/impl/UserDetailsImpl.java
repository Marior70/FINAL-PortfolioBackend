package com.portfolio.backend.seguridad.impl;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.portfolio.backend.seguridad.roles.Rol;
import com.portfolio.backend.seguridad.usuarios.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

   private final Usuario usuario;   

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      List<GrantedAuthority> authorities = usuario.getRoles().stream().map(
         rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());   
      return authorities;
      //return Collections.emptyList();
   }

   @Override
   public String getPassword() {
      return usuario.getPassword();
   }

   @Override
   public String getUsername() {
      return usuario.getUsername();
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }

   public String getName(){
      return usuario.getName();
   }

   public Set<Rol> getRoles(){
      return usuario.getRoles();
   }
}
