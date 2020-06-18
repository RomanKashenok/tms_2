package com.tms.testing.service;

import com.tms.testing.model.User;
import com.tms.testing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        System.out.println("getAllUsers: called at: " + new Date());
        return repo.findAll();
    }

    public User addNewUser(User user) {
        System.out.println("addNewUser: called at: " + new Date());
        return repo.save(user);
    }

    public List<User> getUsersByName(String name) {
        System.out.println("getUsersByName: called at: " + new Date());
        return repo.findUsersByName(name);
    }
}
