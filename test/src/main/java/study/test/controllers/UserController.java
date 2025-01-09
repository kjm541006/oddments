package study.test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.test.DTO.UserDTO;
import study.test.domain.User;
import study.test.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/add")
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable Long id){

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
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO updateUserParam){
        userService.updateUser(id, updateUserParam);
    }
}
