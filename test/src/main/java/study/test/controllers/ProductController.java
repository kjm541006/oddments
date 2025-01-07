package study.test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.test.DTO.ProductDTO;
import study.test.domain.Product;
import study.test.domain.User;
import study.test.services.ProductServiceImpl;
import study.test.services.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;
    private final UserServiceImpl userService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping("/product/add")
    public void addProduct(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());

        User user = userService.findUser(productDTO.getUserId());
        product.setSeller(user);

        productService.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable Long id){

        return productService.getProductById(id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
