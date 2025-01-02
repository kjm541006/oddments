package study.test.repositories;

import org.springframework.stereotype.Repository;
import study.test.domain.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> userList = new ArrayList<>();

    // dummy data
    public UserRepository() {
        userList.add(new User(1L, "Alice12", "Alice", new BigDecimal("100.0")));
        userList.add(new User(2L, "Bob12", "Bob", new BigDecimal("200.0")));
        userList.add(new User(3L, "Charlie12", "Charlie",new BigDecimal("300.0")));
    }

    public void addUser(User user) {
        userList.add(new User(user.getId(), user.getUsername(), user.getName(), user.getAmount()));
    }

    public User findUserById(Long id) {
        Optional<User> userOptional = userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();

        return userOptional.orElse(null);
    }

    public List<User> findAllUsers() {

        return new ArrayList<>(userList);
    }

    public void deleteUserById(Long id) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }

    public void updateUserById(Long id, User updateUserParam){
        for(User user : userList){
            if(user.getId().equals(id)){
                user.setUsername(updateUserParam.getUsername());
                user.setName(updateUserParam.getName());
                user.setAmount(updateUserParam.getAmount());
            }
        }
    }
}
