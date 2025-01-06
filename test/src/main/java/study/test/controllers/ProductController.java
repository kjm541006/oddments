package study.test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.test.domain.Product;
import study.test.services.ProductServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product){
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
