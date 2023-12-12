package com.kcurryjib.mapper;

import com.kcurryjib.dto.CustomerDto;
import com.kcurryjib.dto.ReviewDto;
import com.kcurryjib.entity.Customer;
import com.kcurryjib.entity.Review;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

   @Autowired
   private ModelMapper mapper;

   // convert to DTO
   public CustomerDto convertToCustomerDto(Customer customer) {
      CustomerDto customerDto = mapper.map(customer, CustomerDto.class);

      return customerDto;
   }

   public List<CustomerDto> convertToCustomersDto(List<Customer> customers) {
      return customers.stream()
              .map(this::convertToCustomerDto)
              .collect(Collectors.toList());
   }

   // convert to entity
   public Customer convertToCustomer(CustomerDto customerDto) {
      Customer customer = mapper.map(customerDto, Customer.class);

      return customer;
   }

   public List<Customer> convertToCustomers(List<CustomerDto> customersDto) {
      return customersDto.stream()
              .map(this::convertToCustomer)
              .collect(Collectors.toList());
   }
}
