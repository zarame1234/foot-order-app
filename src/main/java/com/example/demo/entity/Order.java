package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private int quantity; 

  private LocalDateTime orderDate;

  public Order() {
  }
 
  public Order(long id, Product product) {
    this.id = id;
    this.product = product;
  }

  public long getId() {
    return id;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public LocalDateTime getOrderDate() {
    return orderDate;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setOrderDate(LocalDateTime orderDate) {
    this.orderDate = orderDate;
  }
}
