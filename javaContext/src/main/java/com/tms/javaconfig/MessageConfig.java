package com.tms.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tms.javaconfig")
public class MessageConfig {
//
//    @Bean
//    public Message printMessage(){
//        Message message = new Message();
//        message.setMessage("Initial message");
//        return message;
//    }
//
//    @Bean
//    public MessageHolder messageHolder() {
//        MessageHolder messageHolder = new MessageHolder(printMessage());
//        messageHolder.setRepeatTimes(2);
//        return messageHolder;
//    }
}
