package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;

//全コントローラー共通の処理を行うクラス
@ControllerAdvice
public class GlobalExceptionHandler {
  //ProductNotFoundException が発生したら、呼ぶメソッド
  @ExceptionHandler(ProductNotFoundException.class)

  public String handleProductNotFound(ProductNotFoundException e, Model model) {
    model.addAttribute("message", e.getMessage());
    return "error/product-not-found";
  }
}
