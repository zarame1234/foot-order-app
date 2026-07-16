package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long productId;
  private int quantity; 
  private LocalDateTime orderDate;

  public Order() {
  }
 
  public Order(long id, Long productId) {
    this.id = id;
    this.productId = productId;
  }

  public long getId() {
    return id;
  }

  public long getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }
}
