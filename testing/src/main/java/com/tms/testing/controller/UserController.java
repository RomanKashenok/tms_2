package com.tms.testing.controller;


import com.tms.testing.model.User;
import com.tms.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return service.addNewUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/search")
    public List<User> getByName(@RequestParam String name) {
        return service.getUsersByName(name);
    }
}
