package com.portfolio.backend.seguridad.user;

import com.portfolio.backend.seguridad.token.Token;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String name;
   @Column(unique = true)
   private String username;
   @Column(unique = true)
   private String email;
   private String password;
   private String entidad;

   @Enumerated(EnumType.STRING)
   private Role rol;

   @OneToMany(mappedBy = "user")
   private List<Token> tokens;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return List.of(new SimpleGrantedAuthority(rol.name()));
   }   
   // @Override
   // public Collection<? extends GrantedAuthority> getAuthorities() {
   //    List<GrantedAuthority> authorities = usuario.getRoles().stream().map(
   //       rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());   
   //    return authorities;

   @Override
   public String getPassword() {
      return password;
   }

   @Override
   public String getUsername() {
      return username;
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

   public Role getRol(){
      return rol;
   }
}