package com.tms.javaconfig;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Message {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message: " + this.message;
    }

    @PostConstruct
    public void firstMethod() {
        message = "Message from init-method";
    }
}
