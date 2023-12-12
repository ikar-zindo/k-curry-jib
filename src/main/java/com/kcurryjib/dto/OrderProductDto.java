package com.kcurryjib.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OrderProductDto {

   private long id;

   private int quantity;

   private BigDecimal total;

   private LocalDateTime cratedAt;

   @JsonProperty("order")
   private OrderDto orderDto;

   @JsonProperty("product")
   private ProductDto productDto;

   public OrderProductDto() {
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public BigDecimal getTotal() {
      return total;
   }

   public void setTotal(BigDecimal total) {
      this.total = total;
   }

   public LocalDateTime getCratedAt() {
      return cratedAt;
   }

   public void setCratedAt(LocalDateTime cratedAt) {
      this.cratedAt = cratedAt;
   }

   public OrderDto getOrderDto() {
      return orderDto;
   }

   public void setOrderDto(OrderDto orderDto) {
      this.orderDto = orderDto;
   }

   public ProductDto getProductDto() {
      return productDto;
   }

   public void setProductDto(ProductDto productDto) {
      this.productDto = productDto;
   }
}


