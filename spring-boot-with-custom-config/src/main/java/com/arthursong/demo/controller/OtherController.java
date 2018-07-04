package com.arthursong.demo.controller;

import com.arthursong.demo.entity.Other;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/4.
 */
@RestController
public class OtherController {
    @Autowired
    private Other other;

    @GetMapping("/other")
    public Other other(){
        return other;
    }
}
