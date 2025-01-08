package study.test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.test.DTO.ProductDTO;
import study.test.domain.Product;
import study.test.domain.User;
import study.test.services.ProductService;
import study.test.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping("/product/add")
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.saveProduct(productDTO);
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable Long id){

        return productService.getProductById(id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
