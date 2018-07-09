package com.arthursong.demo.controller;

import com.arthursong.demo.entity.User;
import com.arthursong.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        userService.remove(id);
    }

    @PostMapping("/add")
    public void insert(User user) {
        userService.insert(user);
    }

    @PostMapping("/insert")
    public void insertAll(List<User> users) {
        userService.insertAll(users);
    }

    @GetMapping("/find/all")
    public List<User> find(){
        return userService.findAll();
    }

    @GetMapping("/find/page")
    public List<User> findByPage(@RequestParam(name="start",defaultValue = "0") Integer start,
                                 @RequestParam(name="size",defaultValue = "5") Integer size,
                                 User user){
        Pageable pageable=new PageRequest(start, size);
        return userService.findByPage(user, pageable);
    }

    @PostMapping("/update")
    public void update(User user){
        userService.update(user);
    }
}
