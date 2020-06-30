package com.tms.sbsecurity.app.controller;

import com.tms.sbsecurity.app.model.Role;
import com.tms.sbsecurity.app.model.RoleName;
import com.tms.sbsecurity.app.model.User;
import com.tms.sbsecurity.app.repository.RoleRepository;
import com.tms.sbsecurity.app.repository.UserRepository;
import com.tms.sbsecurity.app.security.model.CustomPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.tms.sbsecurity.app.utils.AppUtils.getCurrentUserId;

@RestController
public class TestController {

    private PasswordEncoder pe = new BCryptPasswordEncoder();

    private String defWord = "papaya";

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get")
    public String getString() {
        return "From get method. Username: 'user', Password: 'user'";
    }

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user) {

        if(roleRepository.findAll().isEmpty()) {
            List<Role> roles = new ArrayList<>();
            for(RoleName rn : RoleName.values()) {
                Role role = new Role();
                role.setName(rn);
                roles.add(role);
            }
            roleRepository.saveAll(roles);
        }
        return userRepository.save(user);
    }

    @GetMapping("/info")
    public String getUserInfo() {
        return "Username has ID: " +  getCurrentUserId();
    }
}