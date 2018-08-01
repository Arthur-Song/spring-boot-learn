package com.arthursong.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by Administrator on 2018/8/1.
 */
@Slf4j
@Component
public class Sender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(){
        String message = "Hello World !";
        ListenableFuture future = kafkaTemplate.send("hello",message);
        future.addCallback(
                msg -> log.info("消息发送成功："+msg),
                throwable -> log.error(throwable.getMessage(),throwable)
        );
    }
}
