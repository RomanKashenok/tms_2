package com.tms.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageHolderHolder {

    @Autowired
    @Qualifier("test")
    MessageHolder mh;

    public MessageHolderHolder(MessageHolder mh) {
        this.mh = mh;
    }

    public void printSmth() {
        mh.printMessage();
    }

}
