package study.test.services;

import study.test.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    void saveProduct(Product product);

    void deleteProduct(Long id);
}
