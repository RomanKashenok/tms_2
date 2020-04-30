package com.tms.javaconfig;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);

        Message message = context.getBean(Message.class);

        MessageHolder messageHolder = context.getBean(MessageHolder.class);

        message.setMessage("This is simple message.");
        System.out.println(message);

        messageHolder.printMessage();
    }
}
