package com.kcurryjib.entity;


import com.kcurryjib.entity.enums.OrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "\"order\"")
public class Order {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "order_id")
   private Long id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "customer_id")
   private Customer customer;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "restaurant_id")
   private Restaurant restaurant;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "employee_id")
   private Employee employee;

   @Column(name = "order_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
   private LocalDateTime orderDate;

   @Column(name = "delivery_address")
   private String deliveryAddress;

   @Column(name = "total_amount", precision = 8, scale = 2)
   private BigDecimal totalAmount;

   @Enumerated(EnumType.STRING)
   @Column(name = "order_status")
   private OrderStatus orderStatus;

   @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
   private List<OrderProduct> orderProducts;

   public Order() {
   }

   // Getters & Setters
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public Restaurant getRestaurant() {
      return restaurant;
   }

   public void setRestaurant(Restaurant restaurant) {
      this.restaurant = restaurant;
   }

   public Employee getEmployee() {
      return employee;
   }

   public void setEmployee(Employee employee) {
      this.employee = employee;
   }

   public LocalDateTime getOrderDate() {
      return orderDate;
   }

   public void setOrderDate(LocalDateTime orderDate) {
      this.orderDate = orderDate;
   }

   public String getDeliveryAddress() {
      return deliveryAddress;
   }

   public void setDeliveryAddress(String deliveryAddress) {
      this.deliveryAddress = deliveryAddress;
   }

   public BigDecimal getTotalAmount() {
      return totalAmount;
   }

   public void setTotalAmount(BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public OrderStatus getOrderStatus() {
      return orderStatus;
   }

   public void setOrderStatus(OrderStatus orderStatus) {
      this.orderStatus = orderStatus;
   }

   public List<OrderProduct> getOrderProducts() {
      return orderProducts;
   }

   public void setOrderProducts(List<OrderProduct> orderProducts) {
      this.orderProducts = orderProducts;
   }

   // Builder class
   public static class Builder {

      private Order order = new Order();

      public Builder id(Long id) {
         order.id = id;
         return this;
      }

      public Builder customer(Customer customer) {
         order.customer = customer;
         return this;
      }

      public Builder restaurant(Restaurant restaurant) {
         order.restaurant = restaurant;
         return this;
      }

      public Builder employee(Employee employee) {
         order.employee = employee;
         return this;
      }

      public Builder orderDate(LocalDateTime orderDate) {
         order.orderDate = orderDate;
         return this;
      }

      public Builder deliveryAddress(String deliveryAddress) {
         order.deliveryAddress = deliveryAddress;
         return this;
      }

      public Builder totalAmount(BigDecimal totalAmount) {
         order.totalAmount = totalAmount;
         return this;
      }

      public Builder orderStatus(OrderStatus orderStatus) {
         order.orderStatus = orderStatus;
         return this;
      }

      public Order build() {
         return order;
      }
   }

   public static Builder builder() {
      return new Builder();
   }
}
