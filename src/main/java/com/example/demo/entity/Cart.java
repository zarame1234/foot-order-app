package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private Integer quantity;

  public Long getId() {
    return id;
  }

  public Product getProductId() {
    return product;
  }

  public Integer getQuantity() {
    return  quantity;
  }
  
  public void setId(Long id) {
    this.id = id;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}