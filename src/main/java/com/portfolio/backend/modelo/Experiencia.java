package com.portfolio.backend.modelo;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "experiencias")
public class Experiencia {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String rol;  
   private String fechaIni;
   private String fechaFin;
   private String descripcion;
   
   private String entidad;
   private String logo;
   private String localidad;
   private String provincia;

   public String fullLocalidad() {
      return this.localidad + ", " + this.provincia + ", AR";
   }

   // @ManyToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name = "id_entidad")
   // private Entidad entidad;

   // @ManyToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name = "id_persona")
   // private Persona persona;

}
