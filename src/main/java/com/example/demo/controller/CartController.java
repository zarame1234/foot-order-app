package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class CartController {
  @PostMapping("/cart")
  public String addCart(@RequestBody String entity) {
      //TODO: process POST request
      
      return entity;
  }
  
  public 
}
