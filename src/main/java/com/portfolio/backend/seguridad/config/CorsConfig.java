package com.portfolio.backend.seguridad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

   @Bean
   public WebMvcConfigurer corsConfigurer() {

      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            // System.out.println("-----> WebMvcConfigurer.addCorsMapping");
            registry.addMapping("/auth/**")
                  .allowedOrigins("https://portfolioweb-mrl.web.app")
                  .allowedMethods("*");
                  // .exposedHeaders("*"); //()"Authorization","Rol");

            registry.addMapping("/api/**")
                  .allowedOrigins("https://portfolioweb-mrl.web.app")
                  .allowedMethods("*");
         }
      };
   }

}
