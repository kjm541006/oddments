package study.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import study.test.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
