package com.portfolio.backend.modelo;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "educacion")
public class Educacion {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nivel;
   private String estado;
   private String fechaIni;
   private String fechaFin;

   private String titulo;
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

   // @OneToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name = "id_titulo")
   // private Titulo titulo;

   // @ManyToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name = "id_persona")
   // private Persona persona;

}
