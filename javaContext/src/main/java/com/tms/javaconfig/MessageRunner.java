package com.tms.javaconfig;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);

        MessageHolderHolder mhh = context.getBean(MessageHolderHolder.class);

        mhh.printSmth();
    }
}
