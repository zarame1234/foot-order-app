package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.CartRepository;

@Service
public class CartService {
  public final CartRepository cartRepository;
  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public void addCart(CartForm cartForm) {
    
  }



}
