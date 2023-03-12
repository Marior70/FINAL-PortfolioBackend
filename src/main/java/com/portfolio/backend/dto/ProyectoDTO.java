package com.portfolio.backend.dto;

import lombok.Data;

@Data
public class ProyectoDTO {
   private Long id;
   private String nombre;
   private String logo;
   private String descripcion;
   private String link;
}
