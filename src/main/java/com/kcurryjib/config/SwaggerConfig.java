package com.kcurryjib.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

   @Bean
   public OpenAPI openAPI() {
      return new OpenAPI()
              .addSecurityItem(new SecurityRequirement()
                      .addList("Basic Authentication"))
              .components(new Components()
                      .addSecuritySchemes("Basic Authentication", createAPIKeyScheme()))
              .info(new Info()
                      .title("REST API K-CURRY-JIB")
                      .description("RESTful API for managing awesome features.")
                      .version("1.0")
                      .contact(new Contact()
                              .name("K-Curry Jib").email( "www.k-curry-jib.com").url("root@k-curry-jib.com"))
                      .license(new License()
                              .name("License of API").url("API license URL")));
   }

   private SecurityScheme createAPIKeyScheme() {
      return new SecurityScheme()
              .type(SecurityScheme.Type.HTTP)
              .scheme("basic");
   }
}
