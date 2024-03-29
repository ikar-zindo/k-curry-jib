package com.kcurryjib.mapper.employee;

import com.kcurryjib.dto.EmployeeDto;
import com.kcurryjib.dto.OrderDto;
import com.kcurryjib.dto.OrderProductDto;
import com.kcurryjib.dto.RestaurantDto;
import com.kcurryjib.entity.Employee;
import com.kcurryjib.entity.Order;
import com.kcurryjib.entity.OrderProduct;
import com.kcurryjib.entity.Restaurant;
import com.kcurryjib.mapper.admin.CustomerMapper;
import com.kcurryjib.mapper.admin.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

   @Autowired
   private ModelMapper mapper;

   @Autowired
   private ProductMapper productMapper;

   @Autowired
   CustomerMapper customerMapper;

   // convert to DTO
   public RestaurantDto convertToRestaurantDto(Restaurant restaurant) {
      return mapper.map(restaurant, RestaurantDto.class);
   }

   public EmployeeDto showEmployeeWithOrders(Employee employee) {
      mapper.typeMap(Employee.class, EmployeeDto.class)
              .addMappings(m -> m.skip(EmployeeDto::setPassword));

      EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);

      employeeDto.setOrdersDto(convertToOrdersDto(employee.getOrders()));

      return employeeDto;
   }

   public OrderDto convertToOrderDto(Order order) {
      OrderDto orderDto = mapper.map(order, OrderDto.class);

      orderDto.setCustomerDto(customerMapper.customerInfoDelivery(order.getCustomer()));
      orderDto.setOrderProductsDto(convertToOrderProductsDto(order.getOrderProducts()));
      orderDto.setRestaurantDto(convertToRestaurantDto(order.getRestaurant()));

      return orderDto;
   }

   public OrderProductDto converToOrderProductDto(OrderProduct orderProduct) {
      OrderProductDto orderProductDto = mapper.map(orderProduct, OrderProductDto.class);

      orderProductDto.setProductDto(productMapper.convertToProductDto(orderProduct.getProduct()));

      return orderProductDto;
   }

   public List<OrderDto> convertToOrdersDto(List<Order> orders) {
      return orders.stream()
              .map(this::convertToOrderDto)
              .collect(Collectors.toList());
   }

   public List<OrderProductDto> convertToOrderProductsDto(List<OrderProduct> orderProducts) {
      return orderProducts.stream()
              .map(this::converToOrderProductDto)
              .collect(Collectors.toList());
   }
}
