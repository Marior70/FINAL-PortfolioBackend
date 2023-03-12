package com.portfolio.backend.modelo;

// import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personas")
public class Persona {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nombres;
   private String apellidos;
   private String foto;
   private String email;
   private String movil;
   private String acercade;

   private String Titulo;
   private String localidad;
   private String provincia;

   // @ManyToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name = "id_titulo")
   // private Titulo titulo;

   // @ManyToOne(fetch = FetchType.LAZY, optional = false)
   // @JoinColumn(name = "id_localidad")
   // private Localidad localidad;

   // @Override
   // public String toString() {
   // return this.nombres + this.apellidos;
   // }

   public String fullName() {
      return this.nombres + " " + this.apellidos;
   }

   // public String residencia() {
   //    return this.localidad.fullLocalidad();
   // }

   public String residencia() {
      return this.localidad + ", " + this.provincia + ", AR";
   } 

   // public String miTitulo() {
   //    return this.titulo.getNombre();
   // }     

}
