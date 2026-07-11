package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.form.CartForm;
import com.example.demo.service.CartService;

@Controller
public class CartController {
  public final CartService cartService;
  public CartController(CartService cartService) {
    this.cartService = cartService;
}

  @PostMapping("/cart")
  public String addCart(@ModelAttribute CartForm cartForm) {
      cartService.addCart(cartForm);
      return "redirect:/products";
  }
}
