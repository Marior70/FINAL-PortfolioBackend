package com.portfolio.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

   public static void main(String[] args) {
      SpringApplication.run(BackendApplication.class, args);
   }
}

/* 
@SpringBootApplication
public class BackendApplication extends SprintBootServletInitializer {

   public static void main(String[] args) {
      SpringApplication.run(BackendApplication.class, args);
   }

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder applicatiion) {
      return application.sources(BackendApplication.class);
   }
}
 */