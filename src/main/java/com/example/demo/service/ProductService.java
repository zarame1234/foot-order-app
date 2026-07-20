package com.example.demo.service;

  import org.springframework.stereotype.Service;
  import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.form.ProductForm;
  import com.example.demo.repository.ProductRepository;
  import java.util.List;

  @Service
  public class ProductService {
    public final ProductRepository productRepository;

    public ProductService(ProductRepository productRepositoy) {
      this.productRepository = productRepositoy;
    }

    public List<Product> getProducts() {
      return productRepository.findAll();
    }

    /**
     * 
     * @param id
     * @return 
     *findById() → Optionalを返す
     *orElseThrow() → 見つからなければ例外を投げる
     *() ->：あとで実行する処理
     */
    public Product getProductById(Long id) {
      return productRepository.findById(id)
             .orElseThrow(() ->new ProductNotFoundException(id)
            );
    } 

    public void saveProduct(ProductForm productForm) {
      Product product = new Product();
      product.setName(productForm.getName());
      product.setPrice(productForm.getPrice());
      productRepository.save(product); 
    }
}
