package study.test.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.test.DTO.ProductDTO;
import study.test.domain.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품 생성 테스트")
    void createProduct(){
        // when
        Product product = Product.builder()
                .name("testProductName")
                .description("testProductDesc")
                .price(BigDecimal.valueOf(100))
                .stock(10)
                .build();

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());

        productService.saveProduct(productDTO);

        Assertions.assertThat(product.getName()).isEqualTo("testProductName");
    }


}