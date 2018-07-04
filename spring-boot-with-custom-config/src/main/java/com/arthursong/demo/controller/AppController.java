package com.arthursong.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/4.
 */
@RestController
public class AppController {

    @Value("${app.name}")
    private String name;
    @Value("${app.description}")
    private String description;

    @GetMapping("/app")
    public String app(){
        return "应用名称："+name+",描述："+description;
    }
}
