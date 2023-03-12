package com.portfolio.backend.dto;

import lombok.Data;

@Data
public class ExperienciaDTO {
   private Long id;
   private String entidad;
   private String rol;
   private String logo;
   private String fechaIni;
   private String fechaFin;
   private String descripcion;
   private String fullLocalidad;
}
