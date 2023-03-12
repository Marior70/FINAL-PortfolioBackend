package com.portfolio.backend.seguridad.usuarios;

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
// import javax.validation.constraints.Email;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Size;


@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
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

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
   private Set<Rol> roles = new HashSet<>();

   @NotBlank
   @Column (name= "es_admin")
   private Boolean esAdmin;

   // @JoinColumn(name = "id_entidad")
   // @ManyToOne(fetch = FetchType.LAZY, optional = false)
   // private Entidad entidad;
   private String entidad;

   // public Usuario() {}

   public Usuario(String name, String username, String email, String password, Boolean esAdmin) {
   this.name = name;
   this.username = username;
   this.email = email;
   this.password = new BCryptPasswordEncoder().encode(password);
   this.esAdmin = esAdmin;
   }

}

// package com.portfolio.backend.modelo;

// import jakarta.persistence.*;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.NonNull;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// @Table (name= "usuarios")
// public class Usuario {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
   
//    @NonNull
//    private String nombre;
//    @NonNull
//    private String email;
//    @NonNull
//    private String clave;
//    @NonNull
//    @Column (name= "es_admin")
//    private Boolean esAdmin;

//    @JoinColumn(name = "id_entidad")
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    private Entidad entidad;

//    // Al configurar el atributo 'esAdmin', eliminé del modelo a Grupo, ya que se necesitan dos permisos: "visualizar" y "editar" el portfolio
//    /* @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "id_grupo")
//    private Grupo grupo; */

// }
