package com.tms.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageHolderImpl2 implements MessageHolder {

    @Autowired
    private Message message;

    public MessageHolderImpl2(Message message) {
        this.message = message;
    }

    @Override
    public void printMessage() {
        System.out.println("Message says: " + message.getMessage());
    }
}
