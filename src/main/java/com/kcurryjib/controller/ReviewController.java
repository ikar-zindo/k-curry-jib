package com.kcurryjib.controller;

import com.kcurryjib.dto.ReviewDto;
import com.kcurryjib.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

   @Autowired
   private ReviewService service;

   @GetMapping
   public ResponseEntity<List<ReviewDto>> getAll() {
      List<ReviewDto> reviewsDto = service.getAll();

      return new ResponseEntity<>(reviewsDto, HttpStatus.OK);
   }






}
