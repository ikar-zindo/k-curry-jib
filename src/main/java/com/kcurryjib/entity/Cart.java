package com.kcurryjib.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class Cart {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "cart_id")
   private long id;

   @OneToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;

   @ManyToMany
   @JoinTable(
           name = "cart_product",
           joinColumns = @JoinColumn(name = "cart_id"),
           inverseJoinColumns = @JoinColumn(name = "product_id")
   )
   private List<Product> products;

   public Cart() {
   }

   public Cart(Customer customer) {
      this.customer = customer;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public List<Product> getProducts() {
      return products;
   }

   public void setProducts(List<Product> products) {
      this.products = products;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Cart cart = (Cart) o;
      return id == cart.id && Objects.equals(customer, cart.customer) && Objects.equals(products, cart.products);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, customer, products);
   }

   @Override
   public String toString() {
      return getClass().getSimpleName() + '{' +
              "id=" + id +
              ", customer=" + customer +
              ", products=" + products +
              '}';
   }
}
