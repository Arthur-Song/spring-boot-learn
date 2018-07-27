package com.arthursong.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/7/27.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/user/index")
    public String userIndex(){
        return "user/index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login-error")
    public String index(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }

    @GetMapping("/403")
    public String accessDenied(){
        return "403";
    }
}
