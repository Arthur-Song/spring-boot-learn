package com.arthursong.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2018/8/1.
 */
@Slf4j
@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "Hello World "+new Date();
        log.info("send message:"+message);
        amqpTemplate.convertAndSend("hello",message);
    }
}
