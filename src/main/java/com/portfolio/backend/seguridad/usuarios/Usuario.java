package com.portfolio.backend.seguridad.usuarios;

// import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.EqualsAndHashCode;
// import org.hibernate.annotations.NaturalId;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.portfolio.backend.seguridad.roles.Rol;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
// @AllArgsConstructor
// @EqualsAndHashCode
public class Usuario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank
   @Size(min = 3, max = 50)
   private String name;

   @NotBlank
   @Column(unique = true)
   @Size(min = 3, max = 15)
   private String username;

   // @NaturalId
   @NotBlank
   @Column(unique = true)
   @Size(max = 50)
   @Email
   private String email;

   @NotBlank
   @Size(min = 8, max = 255)
   private String password;

   // @JoinColumn(name = "id_entidad")
   // @ManyToOne(fetch = FetchType.LAZY, optional = false)
   // private Entidad entidad;
   @NotBlank
   private String entidad;

   @NotBlank
   @Column(name = "es_admin")
   private Boolean esAdmin;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
   inverseJoinColumns = @JoinColumn(name = "rol_id"))
   private Set<Rol> roles = new HashSet<>();

   // public Usuario() {}

   public Usuario(String name, String username, String email, String password, String entidad, Boolean esAdmin) {
      this.name = name;
      this.username = username;
      this.email = email;
      this.password = new BCryptPasswordEncoder().encode(password);
      this.entidad = entidad;
      this.esAdmin = esAdmin;
   }

   // public Long getId() {
   //    return id;
   // }

   // public void setId(Long id) {
   //    this.id = id;
   // }

   // public String getName() {
   //    return name;
   // }

   // public void setName(String name) {
   //    this.name = name;
   // }

   // public String getUsername() {
   //    return username;
   // }

   // public void setUsername(String username) {
   //    this.username = username;
   // }

   // public String getEmail() {
   //    return email;
   // }

   // public void setEmail(String email) {
   //    this.email = email;
   // }

   // public String getPassword() {
   //    return password;
   // }

   // public void setPassword(String password) {
   //    this.password = password;
   // }

   // public String getEntidad() {
   //    return entidad;
   // }

   // public void setEntidad(String entidad) {
   //    this.entidad = entidad;
   // }

   // public Boolean getEsAdmin() {
   //    return esAdmin;
   // }

   // public void setEsAdmin(Boolean esAdmin) {
   //    this.esAdmin = esAdmin;
   // }

   // public String Rol() {
   //    if (esAdmin){
   //       return "ROL_ADMIN";
   //    } else {
   //       return "ROL_USER";
   //    }
   // }
}