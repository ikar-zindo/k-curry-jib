package com.kcurryjib.mapper.customer;

import com.kcurryjib.dto.CartDto;
import com.kcurryjib.dto.CartProductDto;
import com.kcurryjib.dto.CustomerDto;
import com.kcurryjib.dto.ProductDto;
import com.kcurryjib.entity.Cart;
import com.kcurryjib.entity.CartProduct;
import com.kcurryjib.entity.Customer;
import com.kcurryjib.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

   @Autowired
   private ModelMapper mapper;

   // convert to DTO
   public ProductDto convertToProductDto(Product product) {
      return mapper.map(product, ProductDto.class);
   }

   public CartProductDto convertToCartProductDto(CartProduct cartProduct) {
      CartProductDto cartProductDto = mapper.map(cartProduct, CartProductDto.class);

      cartProductDto.setProductDto(convertToProductDto(cartProduct.getProduct()));

      return cartProductDto;
   }

   public CartDto convertToCartDto(Cart cart) {
      CartDto cartDto = mapper.map(cart, CartDto.class);

      cartDto.setCartProductsDto(convertToCartProductsDto(cart.getCartProducts()));

      return cartDto;
   }

   public CustomerDto convertToCustomerDto(Customer customer) {
      CustomerDto customerDto = mapper.map(customer, CustomerDto.class);

      customerDto.setCartDto(convertToCartDto(customer.getCart()));

      return customerDto;
   }

   public List<CartProductDto> convertToCartProductsDto(List<CartProduct> cartProducts) {
      return cartProducts.stream()
              .map(this::convertToCartProductDto)
              .collect(Collectors.toList());
   }

   public List<ProductDto> convertToProductsDto(List<Product> products) {
      return products.stream()
              .map(this::convertToProductDto)
              .collect(Collectors.toList());
   }

   // convert to entity
   public Customer convertToCustomer(CustomerDto customerDto) {
      return mapper.map(customerDto, Customer.class);
   }

   public Cart convertToCart(CartDto cartDto) {
      return mapper.map(cartDto, Cart.class);
   }

   public CartProduct convertToCartProduct(CartProductDto cartProductDto) {
      return mapper.map(cartProductDto, CartProduct.class);
   }

   public Product convertToProduct(ProductDto productDto) {
      return mapper.map(productDto, Product.class);
   }

   public List<CartProduct> convertToCartProducts(List<CartProductDto> cartProductsDto) {
      return cartProductsDto.stream()
              .map(this::convertToCartProduct)
              .collect(Collectors.toList());
   }

   public List<Product> convertToProducts(List<ProductDto> productsDto) {
      return productsDto.stream()
              .map(this::convertToProduct)
              .collect(Collectors.toList());
   }
}
