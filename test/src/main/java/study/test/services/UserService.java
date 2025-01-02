package study.test.services;

import study.test.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User findUser(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);
}
