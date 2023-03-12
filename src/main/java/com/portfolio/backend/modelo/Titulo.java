package com.portfolio.backend.modelo;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "titulos")
public class Titulo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;

   // @ManyToOne()
   // @JoinColumn(name = "id_titulo")
   // private Persona persona;

   // @OneToOne(mappedBy = "educacion", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
   // private Educacion educacion;

}
