package com.tms.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageHolder {

    @Autowired
    private Message message;

    public void printMessage() {
        System.out.println("Message says: " + message.getMessage());
    }
}
