package com.portfolio.backend.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.interfaces.IPortfolioService;
import com.portfolio.backend.modelo.Portfolio;

import com.portfolio.backend.repositorio.AptitudRepo;
import com.portfolio.backend.repositorio.CursoRepo;
import com.portfolio.backend.repositorio.EducacionRepo;
import com.portfolio.backend.repositorio.ExperienciaRepo;
import com.portfolio.backend.repositorio.PersonaRepo;
import com.portfolio.backend.repositorio.ProyectoRepo;

@Service
public class PortfolioService implements IPortfolioService {

   @Autowired
   public PersonaRepo perRepo;
   @Autowired
   public ExperienciaRepo expRepo;
   @Autowired
   public EducacionRepo eduRepo;
   @Autowired
   public CursoRepo curRepo;
   @Autowired
   public AptitudRepo aptRepo;
   @Autowired
   public ProyectoRepo proRepo;

   @Override
   public Portfolio obtenerPortfolio() {
      
      Portfolio portfolio = new Portfolio();
      portfolio.setPersona(perRepo.findAll());
      portfolio.setExperiencias(expRepo.findAll());
      portfolio.setEducacion(eduRepo.findAll());
      portfolio.setCursos(curRepo.findAll());
      portfolio.setAptitudes(aptRepo.findAll());
      portfolio.setProyectos(proRepo.findAll());

      return (portfolio);
   }

}
