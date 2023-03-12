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
@Table(name = "provincias")
public class Provincia {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;

   // @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = false)
   // private List<Localidad> localidad;

}
