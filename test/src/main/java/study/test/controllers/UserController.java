package study.test.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.test.domain.User;
import study.test.services.UserServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/user/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/user/find")
    public User findUser(@RequestParam Long id){

        return userService.findUser(id);
    }

    @GetMapping("/user/all")
    public List<User> findAllUser(){

        return userService.getAllUsers();
    }
}
