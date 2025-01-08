package study.test.services;

import study.test.DTO.ProductDTO;
import study.test.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    void saveProduct(ProductDTO productDTO);

    void deleteProduct(Long id);
}
