package com.kcurryjib.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

   private final UserDetailsService userDetailsService;

   @Autowired
   public SecurityConfig(UserDetailsService userDetailsService) {
      this.userDetailsService = userDetailsService;
   }

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
      return new BCryptPasswordEncoder();
   }

// todo: !!! нужно правильно реализовать  securityFilterChain !!!

//   @Bean
//   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//      http // configuration of available methods
//              .csrf(AbstractHttpConfigurer::disable)
//              .sessionManagement(x -> x.sessionCreationPolicy(STATELESS))
//              .logout(
//                      (logout) -> logout
//                              .logoutUrl("/logout")
//                              .permitAll()
//                              .logoutSuccessUrl("/")
//              )
//              .authorizeHttpRequests(
//                      (requests) -> requests
//                              .requestMatchers(
//                                      "/**",
//                                      "/assets/**",
//                                      "/images/**",
//                                      "/error"
//                              )
//                              .permitAll()
////                              .requestMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
////                              .requestMatchers("/**").permitAll()
////                              .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
////                              .requestMatchers(HttpMethod.GET, "/admin/**").permitAll()
////                              .requestMatchers(HttpMethod.GET, "/employees/**").permitAll()
////                              .requestMatchers(HttpMethod.GET, "/employees/all").permitAll()
////                              .requestMatchers(HttpMethod.GET, "/admin/menu").permitAll()
////                              .requestMatchers(HttpMethod.GET, "/admin/rest/dashboard").permitAll()
////                              .requestMatchers(HttpMethod.GET, "/admin/products/rest").permitAll()
////                              .requestMatchers(HttpMethod.GET, "/employees/name").hasAnyRole("ADMIN", "USER")
////                              .requestMatchers(HttpMethod.POST, "/rest/customer/**").hasRole("CUSTOMER")
//                              .anyRequest()
//                              .authenticated()
//              )
//              .formLogin(
//                      (form) -> form
//                              .loginPage("/login")
//                              .permitAll());
//              .httpBasic(Customizer.withDefaults());
//
//      return http.build();
//   }
}
