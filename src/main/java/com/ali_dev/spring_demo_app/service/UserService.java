package com.ali_dev.spring_demo_app.service;

import com.ali_dev.spring_demo_app.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        User user1 = new User(1, "Ali", 21, "ali@mail.com");
        User user2 = new User(2, "Train", 13, "train@mail.com");
        User user3 = new User(3, "Window", 4, "window@mail.com");
        User user4 = new User(4, "Monitor", 6, "monitor@mail.com");
        User user5 = new User(5, "PC", 8, "pc@mail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

    }
    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public List<User> getUsers() {
        return userList;
    }
}
