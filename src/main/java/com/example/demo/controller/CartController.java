package com.example.demo.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.form.CartForm;
import com.example.demo.form.UpdateCartForm;
import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    return "/cart";
  }
  
  /**
   * カート内商品削除
   */
  @PostMapping("cart/delete")
  public String deleteCartProduct(@RequestParam Long cartId) {
       cartService.deleteCartProduct(cartId);
      return "redirect:/cart";
  }
  
  /**
   * カート内商品全削除
   */
  @PostMapping("/cart/deleteAll")
  public String deleteAllCart() {
       cartService.deleteAllCart();
      return "redirect:/cart";
  }

/**
 * カート内商品の数量変更
 */
  @PostMapping("/cart/update")
  public String updateCart(@ModelAttribute UpdateCartForm form) {
    cartService.updateCart(form);
    return "redirect:/cart";
}
}
