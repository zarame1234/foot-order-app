package com.example.demo.service;

  import org.springframework.stereotype.Service;
  import com.example.demo.entity.Product;
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

    public Product getProductById(Long id) {
      return productRepository.findById(id).orElse(null);
    } 

    public Product saveProduct(Product product) {
      return productRepository.save(product); 
    }
}
