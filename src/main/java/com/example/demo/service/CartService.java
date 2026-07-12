package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.form.CartForm;
import com.example.demo.form.UpdateCartForm;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;

@Service
public class CartService {
  public final CartRepository cartRepository;
  public final ProductRepository productRepository;

  public CartService(CartRepository cartRepository, ProductRepository productRepository) {
    this.cartRepository = cartRepository;
    this.productRepository = productRepository;
  }

  /**
   * カートへ商品を追加する
   * @param cartForm
   */
  public void addCart(CartForm cartForm) {
     Cart cart = new Cart();
     Product product = productRepository.findById(cartForm.getProductId()).orElseThrow();

     cart.setProduct(product);
     cart.setQuantity(cartForm.getQuantity());

     cartRepository.save(cart);
  }

  /**
   * カート内商品を取得する
   * @return　カート内容一覧
   */
  public List<Cart> getCartList() {
    return cartRepository.findAll();
  }
  /**
   * カート内商品数量を更新する
   * @param form
   */
  public void updateCart(UpdateCartForm form) {
    Cart cart = cartRepository.findById(form.getCartId())
            .orElseThrow(() -> new RuntimeException("カートが存在しません"));
    cart.setQuantity(form.getQuantity());
    cartRepository.save(cart);
  }

  /**
   * カート内商品を削除する
   * @param cartId 削除対象のカートID
   */
  public void deleteCartProduct(Long cartId) {
    cartRepository.deleteById(cartId);
  }

  /**
   * カート内商品を全削除する
   */
  public void deleteAllCart() {
    cartRepository.deleteAll();
  }
}
