package com.ali_dev.spring_demo_app.api.controller;

import com.ali_dev.spring_demo_app.api.model.User;
import com.ali_dev.spring_demo_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> listOfUsers = userService.getUsers();
        return listOfUsers;
    }
}
