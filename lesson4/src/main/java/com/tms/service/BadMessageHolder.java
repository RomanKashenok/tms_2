package com.tms.service;

import com.tms.annotation.MessageProcessing;
import com.tms.model.Message;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

//@Component
@MessageProcessing
public class BadMessageHolder implements MessageHolder {

    private Message message;

    public BadMessageHolder() {
        System.out.println("BadMessageHolder Default constructor invocation");
        System.out.println(message.getMessage());
    }

    public BadMessageHolder(Message message) {
        this.message = message;
        System.out.println("BadMessageHolder Constructor with arguments invocation");
        System.out.println(message.getMessage());
    }

    @PostConstruct
    public void init() {
        System.out.println("BadMessageHolder init() method invocation");
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
                : "Help me, Obi-Wan Kenobi. You're my only hope.";
        System.out.println(mess);
    }
}
