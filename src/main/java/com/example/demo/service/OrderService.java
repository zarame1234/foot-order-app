package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
  public final OrderRepository orderRepository;
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> getOrders() {
    return orderRepository.findAll();  
  }
}
  
  /*
  public List<Order> getOrders() {
    List<Order> orders = new ArrayList<>();
      orders.add(new Order(1L, 2L));
      orders.add(new Order(2L, 1L));

      return orders;
  }
  */
