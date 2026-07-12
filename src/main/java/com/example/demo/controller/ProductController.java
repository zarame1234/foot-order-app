package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.ProductService;
import com.example.demo.service.CartService;
import com.example.demo.form.CartForm;
import com.example.demo.form.ProductForm;
import com.example.demo.form.UpdateCartForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
public class ProductController {
  private final ProductService productService;
  private final CartService cartService;

  public ProductController(ProductService productService, CartService cartService) {
    this.productService = productService;
    this.cartService = cartService;
  }
  
  @GetMapping("/products")
  public String showProducts(Model model) {
    model.addAttribute("products", productService.getProducts());
    model.addAttribute("ProductForm", new ProductForm());
    return "products";
  }

  //注文詳細画面表示
  @GetMapping("/products/{id}")
    public  String showProductDatail(@PathVariable Long id, Model model) {
      model.addAttribute("product", productService.getProductById(id));
      model.addAttribute("cartForm", new CartForm());
    return "product-detail";
  } 

  @PostMapping("/cart/update")
  public String updateCart(@ModelAttribute UpdateCartForm updateCartForm) {
    cartService.updateCart(updateCartForm);
    return "redirect:/cart";
  }

  /*商品登録は別で作成予定
  @PostMapping("/products")
  public String saveProduct(ProductForm  productForm) {
    productService.saveProduct(productForm);
    return "redirect:/products";
  }
  */
}
