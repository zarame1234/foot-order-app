package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

  @Id
  private Long id;
  private Long productId;

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
}
