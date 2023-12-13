package com.kcurryjib.controller.admin;

import com.kcurryjib.dto.ProductDto;
import com.kcurryjib.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/admin/products")
public class ProductController {

   @Autowired
   private ProductService service;

   @GetMapping
   public String getAll(Model model) {
      List<ProductDto> productsDto = service.gatAll();

      model.addAttribute("products", productsDto);

      return "admin/products/all";
   }


}