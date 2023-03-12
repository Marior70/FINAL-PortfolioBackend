package com.portfolio.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.modelo.Portfolio;
import com.portfolio.backend.interfaces.IPortfolioService;
import com.portfolio.backend.convertidorEntidadDto.PortfolioConv;
import com.portfolio.backend.dto.PortfolioDTO;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class PortfolioCont {
   
   @Autowired
   private IPortfolioService portfolioServ;
   @Autowired
   private PortfolioConv portfolioDto;

   @GetMapping("/portfolio")
   @ResponseBody
   public PortfolioDTO obtenerPortfolio() {
      Portfolio portfolio = portfolioServ.obtenerPortfolio();
      return portfolioDto.portfolioToDto(portfolio);
   }
}
