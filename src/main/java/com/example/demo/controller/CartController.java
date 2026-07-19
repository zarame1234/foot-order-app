package com.example.demo.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.form.CartForm;
import com.example.demo.form.UpdateCartForm;
import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class CartController {
  public final CartService cartService;
  public final ProductService productService;
  public CartController(CartService cartService, ProductService productService) {
    this.cartService = cartService;
    this.productService = productService;
}

  @PostMapping("/cart")
  public String addCart(@Valid @ModelAttribute CartForm cartForm, BindingResult result, Model model) {
     if (result.hasErrors()) {
        model.addAttribute("product", productService.getProductById(cartForm.getProductId()));
        return "product-detail";
    }
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
  public String updateCart(@ModelAttribute UpdateCartForm form, Model model) {

    cartService.updateCart(form);
    return "redirect:/cart";
}
}
