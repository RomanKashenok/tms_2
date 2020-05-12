package com.tms.security.service;

import com.tms.dao.RoleDao;
import com.tms.dao.StudentDao;
import com.tms.model.Role;
import com.tms.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private RoleDao roleDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentDao.findByUsername(username);
        List<Role> roles = roleDao.findUserRoles(student.getId());

        return User.builder()
                .username(student.getUsername())
                .password(student.getPassword())
                .roles(roles.stream().map(Role::getName).collect(Collectors.joining()))
                .build();
    }
}
