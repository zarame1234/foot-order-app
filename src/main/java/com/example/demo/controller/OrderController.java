package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.service.OrderService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.entity.Order;


/*注文履歴
@RestController
public class OrderController {

  private final OrderService orderService;
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/orders")
  public String showOrders(Model model) {
      List<Order> orders = orderService.getOrders();
      model.addAttribute("orders", orders);
      return "orders";
  }
*/
}
