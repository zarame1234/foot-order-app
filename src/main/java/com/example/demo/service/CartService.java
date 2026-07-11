package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.CartRepository;
import com.example.demo.form.CartForm;
import com.example.demo.entity.Cart;;

@Service
public class CartService {
  public final CartRepository cartRepository;
  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public void addCart(CartForm cartForm) {
     Cart cart = new Cart();
     cart.setProductId(cartForm.getProductId());
     cart.setQuantity(cartForm.getQuantity());

     cartRepository.save(cart);
  }



}
