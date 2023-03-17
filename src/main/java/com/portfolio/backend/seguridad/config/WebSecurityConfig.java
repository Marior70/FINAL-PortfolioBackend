package com.portfolio.backend.seguridad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.portfolio.backend.seguridad.filtros.JWTAuthenticationFilter;
import com.portfolio.backend.seguridad.filtros.JWTAuthorizationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

   private final UserDetailsService userDetailsService; 
   private final JWTAuthorizationFilter jwtAuthorizationFilter; 

   @Bean
   SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
      JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter(); 
      jwtAuthenticationFilter.setAuthenticationManager(authManager); 
      jwtAuthenticationFilter.setFilterProcessesUrl("/abrirportfolio"); 
      
      System.out.println("-----> WebSecurityConfig / filterChain (jwtAuthenticationFilter --> URL: /abrirportfolio ");
      System.out.println();

      return http
            .cors()
            .and()
            .csrf().disable() // Deshabilita el cross site request forgery
            .authorizeHttpRequests() // Entramos a las reglas de solicitudes
            // .requestMatchers("/abrirportfolio") // Regla que a cualquier request a "/abrirportfolio"
            // .permitAll() // lo deja pasar aún sin token,
            .anyRequest() // le indicamos que cada solicitud que ingrese
            .authenticated() // Debe estar autenticada
            .and() // Además
            .sessionManagement() // Entramos a la gestión de la sesiones
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Creamos la política de creación de sesiones y la establecemos a "sin estado"
            .and() // y finalmente
            .addFilter(jwtAuthenticationFilter) // 
            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class) // 
            .build(); // Construimos lo que sería el SecurityFilterChain

   }

   // Para probar esta implementación, vamos a producir un Bean que retornará un userdetailsService. Cargará unos usuarios en memoria, por ahora no nos conectaremos a la BD, luego esto de dehabilitará.

   // @Bean
   // UserDetailsService userDetailsService() {
   // InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
   // manager.createUser(User.withUsername("mariol")
   // .password(passwordEncoder().encode("1234qwER$"))
   // .roles("ROL_ADMIN","ROL_USER")
   // .build());
   // return manager;
   // }

   // Para que todo esto tome efecto, vamos a producir un Authentication Manager
   @Bean
   AuthenticationManager authManager(HttpSecurity http) throws Exception {
      System.out.println();
      System.out.println("-----> WebSecurityConfig / authManager --> Http: (userDetailsService)");
      System.out.println();
      return http.getSharedObject(AuthenticationManagerBuilder.class)
            // .userDetailsService(userDetailsService()) // Esto es para que tome al usuario creado en memoria en el primer uso
            .userDetailsService(userDetailsService) // Esto es para la versión definitiva, sin el UserDetailsService en memoria
            .passwordEncoder(passwordEncoder())
            .and()
            .build();
   }

   // también necesitamos producir una implementacion de PasswordEncoder que
   // también será un Bean, y va a retornar una de las implementaciones, en este
   // caso utilizaremos BCryptPasswordEndocer, pero podría ser otra incluso una
   // personalizada de la empresa.
   @Bean
   PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   // Generador de clave encriptada para una primera clave en etapa de desarrollo y
   // poder probar con postman
   
     /* public static void main(String[] args) {
     System.out.println("-----------> pass: " + new
     BCryptPasswordEncoder().encode("invitado"));
     } */
   

   /* ************************ */
   /* mariol 1234qwER$ */
   /* profe profesor */
   /* guess invitado */
   /* ************************ */

}
