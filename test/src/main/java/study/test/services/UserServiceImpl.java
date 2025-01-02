package study.test.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.test.domain.User;
import study.test.repositories.UserRepository;
//import study.test.repositories.UserRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

//    private final UserRepositoryImpl userRepositoryImpl;
    private final UserRepository userRepository;

//    @Override
//    public void addUser(User user) {
//        userRepositoryImpl.addUser(user);
//    }
//
//    @Override
//    public User findUser(Long id) {
//
//        return userRepositoryImpl.findUserById(id);
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepositoryImpl.findAllUsers();
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepositoryImpl.deleteUserById(id);
//    }
//
//    @Override
//    public void updateUser(Long id, User updateUserParam) {
//        userRepositoryImpl.updateUserById(id, updateUserParam);
//    }


    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User updateUserParam) {
        Optional<User> findedUser = userRepository.findById(id);
        if(findedUser.isPresent()){
            User user = findedUser.get();
            user.setUsername(updateUserParam.getUsername());
            user.setName(updateUserParam.getName());
            user.setAmount(updateUserParam.getAmount());
            userRepository.save(user);
        }
    }
}
