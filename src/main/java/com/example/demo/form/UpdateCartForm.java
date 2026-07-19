package com.example.demo.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UpdateCartForm {
  private Long cartId;

  @NotNull(message = "数量を入力してください")
  @Min(value = 1, message = "1以上入力してください")
  @Max(value = 99, message = "99以下で入力してください")
  private Integer quantity;

  public Long getCartId() {
    return cartId;
  }

  public void setCartId(Long cartId) {
    this.cartId = cartId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
} 

