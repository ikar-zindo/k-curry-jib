package com.kcurryjib.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassGenerator {


   public static void main(String[] args) {

      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      System.out.println(encoder.encode("1qaz"));
   }
}
