package com.tms.config;

import com.tms.model.Message;
import com.tms.service.BadMessageHolder;
import com.tms.service.GoodMessageHolder;
import com.tms.service.MessageHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ContextConfig {

    @Bean
    public MessageHolder getGoodMessageHolder() {
        return new GoodMessageHolder(new Message("GOOD NEWS, MASTER"));
    }

    @Bean
    @Primary
    public MessageHolder getBadMessageHolder() {
        return new BadMessageHolder(new Message("BAD NEWS, MOTHER FUCKER!!!"));
    }

}