package com.portfolio.backend.modelo;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "proyectos")
public class Proyecto {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private String logo;
   private String descripcion;
   private String link;
   
   // @ManyToOne(fetch = FetchType.EAGER, optional = false)
   // @JoinColumn(name = "id_persona")
   // private Persona persona;

}
