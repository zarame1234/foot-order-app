package com.example.demo.controller;
import com.example.demo.service.OrderService;
import com.example.demo.service.CartService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
  private final CartService cartService;
  private final OrderService orderService;
  public OrderController(CartService cartService, OrderService orderService) {
    this.cartService = cartService;
    this.orderService = orderService;
  }

  /**
   * 注文確認画面を表示する
   */
  @GetMapping("/orders")
  public String showOrder(Model model) {
    model.addAttribute("cartItems",cartService.getCartList());
    model.addAttribute("totalPrice", cartService.getTotalPrice());
    return "order";
  }

  /**
   * 注文確定処理
   * @return　注文完了画面
   */
  @PostMapping("/orders")
  public String order() {
    orderService.createOrder();
    return "redirect:/orders/complete";
  }

  /**
   * 注文完了画面を表示する
   */
  @GetMapping("/orders/complete")
  public String complete() {
    return "order-complete";
  }
  
  @GetMapping("/orders/history")
  public String showOrdersHsitory(Model model) {
    model.addAttribute("orders", orderService.getOrderList());
    return "order-history";
  }
}

