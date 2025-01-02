package study.test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.test.DTO.UserDTO;
import study.test.domain.User;
import study.test.services.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/user/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/user/{id}")
    public Optional<User> findUser(@PathVariable Long id){

        return userService.findUser(id);
    }

    @GetMapping("/users")
    public List<User> findAllUser(){

        return userService.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User updateUserParam){
        userService.updateUser(id, updateUserParam);
    }
}
