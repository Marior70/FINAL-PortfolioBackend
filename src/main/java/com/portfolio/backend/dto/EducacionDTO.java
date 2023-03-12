package com.portfolio.backend.dto;

import lombok.Data;

@Data
public class EducacionDTO {
   private Long id;
   private String nivel;
   private String estado;   
   private String fechaIni;
   private String fechaFin;
   private String titulo;
   private String entidad;
   private String logo;
   private String fullLocalidad;   
}
