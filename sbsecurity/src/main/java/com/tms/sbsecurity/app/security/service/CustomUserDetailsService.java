package com.tms.sbsecurity.app.security.service;

import com.tms.sbsecurity.app.model.User;
import com.tms.sbsecurity.app.repository.UserRepository;
import com.tms.sbsecurity.app.security.model.CustomPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    @Autowired
    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new CustomPrincipal(user);
    }
}
