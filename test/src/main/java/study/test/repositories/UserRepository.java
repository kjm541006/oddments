package study.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import study.test.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
