package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//動作確認用に使用
@ RestController
public class HelloController { 

  @GetMapping("/")
  public String Hello() {
      return " ";
  }

}
