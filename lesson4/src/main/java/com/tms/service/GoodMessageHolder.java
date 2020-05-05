package com.tms.service;

import com.tms.model.Message;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

//@Component
//@Primary
//@Profile("!dev")
public class GoodMessageHolder implements MessageHolder {

    private Message message;

    public GoodMessageHolder() {
        System.out.println("GoodMessageHolder Default constructor invocation");
        System.out.println(message.getMessage());
    }

    public GoodMessageHolder(Message message) {
        this.message = message;
        System.out.println("GoodMessageHolder Constructor with arguments invocation");
        System.out.println(message.getMessage());
    }

    @PostConstruct
    public void init() {
        System.out.println("GoodMessageHolder init() method invocation");
        System.out.println(message.getMessage());
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void printMessage() {
        final String mess = Objects.nonNull(message)
                ? message.getMessage()
                : "Chewie, we're home.";
        System.out.println(mess);
    }
}
