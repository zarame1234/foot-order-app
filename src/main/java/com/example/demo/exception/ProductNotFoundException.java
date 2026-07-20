package com.example.demo.exception;

/**
 * 商品が見つからない場合の例外処理
 * @param id
 * RunTimeException：Java仮想マシンの通常の処理でスローすることができる各種の例外のスーパークラス
 */
public class ProductNotFoundException extends RuntimeException{
  public ProductNotFoundException(Long id) {
    super("商品が見つかりませんでした。商品ID：" + id);
  }
}