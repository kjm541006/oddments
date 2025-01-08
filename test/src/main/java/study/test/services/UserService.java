package study.test.services;

import study.test.DTO.UserDTO;
import study.test.domain.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(UserDTO userDTO);

    User findUser(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);

    void updateUser(Long id, UserDTO updateUserParam);

    boolean transferBalance(Long senderId, Long receiverId, BigDecimal amount);
}
