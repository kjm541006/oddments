package study.test.services;

import study.test.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    void saveProduct(ProductDTO productDTO);

    void deleteProduct(Long id);

    void updateProduct(Long id, ProductDTO productDTO);
}
