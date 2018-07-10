package com.arthursong.demo.controller;

import com.arthursong.demo.entity.User;
import com.arthursong.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list(){
        return userService.findAll();
    }

    @PostMapping("/user")
    public int save(User user){
        return userService.saveOrUpdate(user);
    }

    @GetMapping("/user")
    public User get(Long id){
        return userService.get(id);
    }

    @DeleteMapping("/user")
    public void remove(Long id){
        userService.remove(id);
    }

    @GetMapping("/user/byUsernameOrEmail")
    public User getByUsernameOrEmail(String keyword){
        return userService.getByUsernameOrEmail(keyword);
    }
}
