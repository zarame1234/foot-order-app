package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.entity.Order;


@RestController
public class OrderController {

  private final OrderService orderService;
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/orders")
  public List<Order> getOrders() {
      return orderService.getOrders();
  }
  
}
