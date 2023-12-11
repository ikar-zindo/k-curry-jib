package com.kcurryjib.controller;

import com.kcurryjib.dto.EmployeeDto;
import com.kcurryjib.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

   @Autowired
   private EmployeeService employeeService;

   @GetMapping
   public ResponseEntity<List<EmployeeDto>> getAll() {
      List<EmployeeDto> employeesDto = employeeService.getAll();

      return new ResponseEntity<>(employeesDto, HttpStatus.OK);
   }

}
