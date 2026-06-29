package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;

@Service
public class OrderService {
  
  public List<Order> getOrders() {
    List<Order> orders = new ArrayList<>();
      orders.add(new Order(1L, 2L));
      orders.add(new Order(2L, 1L));

        return orders;
  }
}
