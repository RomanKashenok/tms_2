package com.example.exhandlingdemo.controller;

import com.example.exhandlingdemo.service.ExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController extends BaseController{

    @Autowired
    private ExService exService;

    @GetMapping("/fine")
    public String getFineResponse() {
        return "fine response, current user ID: " + getUserId() + "\n username: " + getUsername();
    }

    @GetMapping("/ex")
    public String getExResponse (@RequestParam Integer a, @RequestParam Integer b) {
        return exService.method(a,b);
    }

}
