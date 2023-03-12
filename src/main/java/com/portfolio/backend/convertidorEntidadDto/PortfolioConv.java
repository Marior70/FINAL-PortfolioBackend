package com.portfolio.backend.convertidorEntidadDto;

// import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.backend.dto.PortfolioDTO;
import com.portfolio.backend.modelo.Portfolio;

@Component
public class PortfolioConv {
   
   @Autowired
   private PersonaConv listPerDto;
   @Autowired
   private ExperienciaConv listExpDto;
   @Autowired
   private EducacionConv listEduDto;
   @Autowired
   private CursoConv listCurDto;
   // @Autowired
   // private AptitudConv listAptDto;
   @Autowired
   private ProyectoConv listProDto;

   public PortfolioDTO portfolioToDto(Portfolio portfolio) {

      PortfolioDTO dto = new PortfolioDTO();

      dto.setPersona(listPerDto.listarPersonaDto(portfolio.getPersona()));
      dto.setExperiencias(listExpDto.listarExperienciaDto(portfolio.getExperiencias()));
      dto.setEducacion(listEduDto.listarEducacionDto(portfolio.getEducacion()));
      dto.setCursos(listCurDto.listarCursoDto(portfolio.getCursos()));
      // dto.setAptitudes(listAptDto.listarAptitudDto(portfolio.getAptitudes()));
      dto.setProyectos(listProDto.listarProyectoDto(portfolio.getProyectos()));

      return dto;
   }

   /* public List<PortfolioDTO> listarPortfolioDto(List<Portfolio> portfolioList) {

      return portfolioList.stream().map(x -> portfolioToDto(x)).collect(Collectors.toList());
   } */
}