package study.test.services;

import study.test.DTO.ProductDTO;
import study.test.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    ProductDTO getProductById(Long id);

    void saveProduct(ProductDTO productDTO);

    void deleteProduct(Long id);
}
