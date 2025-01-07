package study.test.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import study.test.DTO.UserDTO;
import study.test.domain.User;
import study.test.repositories.UserRepository;
//import study.test.repositories.UserRepositoryImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

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
    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
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
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            User user = foundUser.get();
            user.setUsername(updateUserParam.getUsername());
            user.setName(updateUserParam.getName());
            user.setAmount(updateUserParam.getAmount());
            userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public boolean transferBalance(Long senderId, Long receiverId, BigDecimal amount) {

        if (senderId == null || receiverId == null || amount == null) {
            throw new IllegalArgumentException("id나 amount는 null이어서는 안됩니다.");
        }

        Optional<User> senderOptional = userRepository.findById(senderId);
        Optional<User> receiverOptional = userRepository.findById(receiverId);

        if (senderOptional.isPresent() && receiverOptional.isPresent()) {
            User sender = senderOptional.get();
            User receiver = receiverOptional.get();

            if (sender.getAmount().compareTo(amount) >= 0) {
                sender.setAmount(sender.getAmount().subtract(amount));
                receiver.setAmount(receiver.getAmount().add(amount));

                userRepository.save(sender);
                userRepository.save(receiver);

                return true;
            }else{

                return false;
            }
        }

        return false;
    }
}