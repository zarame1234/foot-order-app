package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
  public final OrderRepository orderRepository;
  private final CartRepository cartRepository;
  public OrderService(OrderRepository orderRepository, CartRepository cartRepository) {
    this.orderRepository = orderRepository;
    this.cartRepository = cartRepository;
  }

  public List<Order> getOrders() {
    return orderRepository.findAll();  
  }
  
  /**
   * 注文を確定する
   */
  public void createOrder() {
    List<Cart> cartList = cartRepository.findAll();
    for (Cart cart : cartList) {
      Order order = new Order();

      order.setProduct(cart.getProduct());
      order.setQuantity(cart.getQuantity());
      order.setOrderDate(LocalDateTime.now());
      orderRepository.save(order);
    }
    // 注文後はカートを空にする
    cartRepository.deleteAll();
  }
}
  
  /*
  public List<Order> getOrders() {
    List<Order> orders = new ArrayList<>();
      orders.add(new Order(1L, 2L));
      orders.add(new Order(2L, 1L));

      return orders;
  }
  */
