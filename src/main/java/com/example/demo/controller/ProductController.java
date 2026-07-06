package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }
  
  @GetMapping("/products")
  public String showProducts(Model model) {
    model.addAttribute("products", productService.getProducts());
    return "products";
  }

  //注文詳細画面表示
  @GetMapping("/products/{id}")
    public  String showProductDatail(@PathVariable Long id, Model model) {
      model.addAttribute("product", productService.getProductById(id));
    return "product-detail";
  } 

  @PostMapping("/products")
  public String saveProduct(Product product) {
    productService.saveProduct(product);
    return "redirect:/products";
  }
}
