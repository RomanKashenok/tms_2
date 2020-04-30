package com.tms.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("test")
public class MessageHolderImpl1 implements MessageHolder {

    @Autowired
    private Message message;

    private int repeatTimes=2;

    public MessageHolderImpl1(Message message) {
        this.message = message;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    @Override
    public void printMessage() {
        for (int i = 0; i < repeatTimes; i++) {
            System.out.println("Message says: " + message.getMessage());
        }
    }
}
