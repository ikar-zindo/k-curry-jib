package com.kcurryjib.config;

import com.kcurryjib.service.admin.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http // configuration of available methods
              .csrf(AbstractHttpConfigurer::disable)
              .sessionManagement(x -> x.sessionCreationPolicy(STATELESS))
              .authorizeHttpRequests(
                      x -> x
                              .requestMatchers(HttpMethod.GET, "/**").permitAll()
                              .requestMatchers(HttpMethod.GET, "/admin/**").permitAll()
                              .requestMatchers(HttpMethod.GET, "/employees/**").permitAll()
//                              .requestMatchers(HttpMethod.GET, "/employees/all").permitAll()
//                              .requestMatchers(HttpMethod.GET, "/admin/menu").permitAll()
//                              .requestMatchers(HttpMethod.GET, "/admin/rest/dashboard").permitAll()
//                              .requestMatchers(HttpMethod.GET, "/admin/products/rest").permitAll()
//                              .requestMatchers(HttpMethod.GET, "/employees/name").hasAnyRole("ADMIN", "USER")
//                              .requestMatchers(HttpMethod.POST, "/employees/save").hasRole("ADMIN")
                              .anyRequest().authenticated())
              .httpBasic(Customizer.withDefaults());

      return http.build();
   }
}
