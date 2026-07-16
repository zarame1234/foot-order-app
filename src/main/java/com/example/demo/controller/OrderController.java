package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.service.OrderService;
import com.example.demo.service.CartService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Order;
@Controller
public class OrderController {
  private final CartService cartService;
  public OrderController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping("/orders")
  public String showOrder(Model model) {
    model.addAttribute("cartItems",
    cartService.getCartList());
    return "order";
  }
  @PostMapping("/orders")
  public String order() {
    orderService.createOrder();
    return "redirect:/orders/complete";
  }
}
  


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

