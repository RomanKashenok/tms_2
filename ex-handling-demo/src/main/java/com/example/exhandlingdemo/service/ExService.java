package com.example.exhandlingdemo.service;

import org.springframework.stereotype.Service;

@Service
public class ExService {

    public String method(Integer a, Integer b) {
        if(a > 100) throw new IllegalArgumentException("Argument a shold be less than 100");
        return "Result a: " + a + " divide on b: " + b + " = " + (a / b);
    }

}
