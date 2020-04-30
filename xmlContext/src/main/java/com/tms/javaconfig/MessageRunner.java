package com.tms.javaconfig;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRunner {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Message m1 = context.getBean(Message.class);
        System.out.println(m1.hashCode());
        System.out.println(m1.toString());

        Message m2 = context.getBean(Message.class);
        System.out.println(m2.hashCode());
        System.out.println(m2.toString());

        Message m3 = context.getBean(Message.class);
        System.out.println(m1.hashCode());
        System.out.println(m3.toString());

        Message m4 = context.getBean(Message.class);
        System.out.println(m2.hashCode());
        System.out.println(m4.toString());

        Message m5 = context.getBean(Message.class);
        System.out.println(m1.hashCode());
        System.out.println(m5.toString());

        Message m6 = context.getBean(Message.class);
        System.out.println(m2.hashCode());
        System.out.println(m6.toString());


    }
}
