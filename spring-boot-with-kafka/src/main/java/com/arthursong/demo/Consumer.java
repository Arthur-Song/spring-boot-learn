package com.arthursong.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/8/1.
 */
@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = {"hello"})
    public void consume(String message){
        log.info("consume message: "+message);
    }
}
