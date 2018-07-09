package com.arthursong.demo.controller;

import com.arthursong.demo.entity.User;
import com.arthursong.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="获取所有用户列表", notes="获取所有用户列表")
    @GetMapping("/users")
    public List<User> list(){
        return userService.findAll();
    }

    @ApiOperation(value="新增用户", notes="新增用户")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @PostMapping("/user")
    public int save(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id){
        return userService.get(id);
    }

    @ApiOperation(value="通过ID删除用户", notes="根据url的id来删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
    @DeleteMapping("/user/{id}")
    public void remove(@PathVariable Long id){
        userService.remove(id);
    }

    @ApiOperation(value="获取用户名或邮箱查询一个用户", notes="获取用户名或邮箱查询一个用户")
    @ApiImplicitParam(name = "keyword", value = "查询关键字", required = true, dataType = "String")
    @GetMapping("/user/byUsernameOrEmail")
    public User getByUsernameOrEmail(String keyword){
        return userService.getByUsernameOrEmail(keyword);
    }
}
