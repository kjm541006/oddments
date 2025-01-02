package study.test.services;

import study.test.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);

    Optional<User> findUser(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);

    void updateUser(Long id, User updateUserParam);
}
