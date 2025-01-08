package study.test.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.test.DTO.ProductDTO;
import study.test.domain.Product;
import study.test.domain.User;
import study.test.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final UserService userService;

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {

        return productRepository.findById(id);
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());

        User user = userService.findUser(productDTO.getUserId());
        product.setSeller(user);

        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
