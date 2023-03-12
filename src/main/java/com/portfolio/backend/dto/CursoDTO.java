package com.portfolio.backend.dto;

import lombok.Data;

@Data
public class CursoDTO {
   private Long id;
   private String tema;
   private String fechaIni;
   private String fechaFin;   
   private String entidad;
   private String logo;
   private String fullLocalidad;
}
