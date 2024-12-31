package study.test.repositories;

import org.springframework.stereotype.Repository;
import study.test.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(new User(user.getId(), user.getUsername(), user.getName(), user.getAmount()));
    }

    public User findUserById(Long id){
        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

        return userOptional.orElse(null);
    }

    public List<User> findAllUsers(){

        return new ArrayList<>(userList);
    }
}
