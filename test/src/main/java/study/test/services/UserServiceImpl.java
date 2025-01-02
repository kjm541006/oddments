package study.test.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.test.domain.User;
import study.test.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User findUser(Long id) {

        return userRepository.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public void updateUser(Long id, User updateUserParam) {
        userRepository.updateUserById(id, updateUserParam);
    }
}
