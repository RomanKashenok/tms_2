package com.tms.javaconfig;

public class MessageHolder {

    private Message message;

    public MessageHolder(Message message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Message says: " + message.getMessage());
    }
}
