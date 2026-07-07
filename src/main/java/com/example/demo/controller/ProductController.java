package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.ProductService;
import com.example.demo.form.ProductForm;
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
    model.addAttribute("ProductForm", new ProductForm());
    return "products";
  }

  //注文詳細画面表示
  @GetMapping("/products/{id}")
    public  String showProductDatail(@PathVariable Long id, Model model) {
      model.addAttribute("product", productService.getProductById(id));
    return "product-detail";
  } 

  /*商品登録は別で作成予定
  @PostMapping("/products")
  public String saveProduct(ProductForm  productForm) {
    productService.saveProduct(productForm);
    return "redirect:/products";
  }
  */
}
