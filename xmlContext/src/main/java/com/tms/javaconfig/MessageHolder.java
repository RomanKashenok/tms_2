package com.tms.javaconfig;

public class MessageHolder {

    private Message message;

    private int repeatTimes;

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public MessageHolder(Message message) {
        this.message = message;
    }

    public void printMessage() {
        for (int i = 0; i < repeatTimes; i++) {
            System.out.println("Message says: " + message.getMessage());
        }
    }
}
