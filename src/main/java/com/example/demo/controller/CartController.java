package com.example.demo.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.form.CartForm;
import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/cart")
  public String showCart(Model model) {
    List<Cart> cartItems = cartService.getCartList();
    model.addAttribute("cartItems", cartItems);
    return "cart";
  }
  
}
