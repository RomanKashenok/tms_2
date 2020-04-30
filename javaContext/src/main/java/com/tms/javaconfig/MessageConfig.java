package com.tms.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public Message printMessage(){
        return new Message();
    }

    @Bean
    public MessageHolder messageHolder() {
        return new MessageHolder();
    }
}
