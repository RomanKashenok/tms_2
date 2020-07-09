package com.tms.fullstackbackend.controller;

import com.tms.fullstackbackend.security.model.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:3000"})
public class AuthController {

    @GetMapping("/auth")
    public Authentication auth() {
        return new Authentication("auth successful");
    }

}
