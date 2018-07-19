package com.arthursong.demo.controller;

import com.arthursong.demo.entity.User;
import com.arthursong.demo.service.UserService;
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

    /**
     * @api {GET} /users 用户列表
     * @apiName UserList
     * @apiGroup Users
     * @apiVersion 0.0.1-SNAPSHOT
     * @apiDescription 用于获取所有用户列表
     * @apiSuccessExample {json} 返回样例:
     *                [{"id":1,"username":"arthursong","email":"arthurdev@163.com","password":"123456","age":18}]
     */
    @GetMapping("/users")
    public List<User> list(){
        return userService.findAll();
    }

    /**
     * @api {POST} /user 保存用户
     * @apiName SaveUser
     * @apiGroup Users
     * @apiVersion 0.0.1-SNAPSHOT
     * @apiDescription 用于保存或修改用户
     * @apiParam {json} user 用户
     * @apiParamExample {json} 请求样例：
     *  {
     *      "username":"arthursong",
     *      "email":"arthurdev@163.com",
     *      "password":"123456",
     *      "age":18
     *  }
     *  @apiSuccess (200) {int} 1 1:表示成功
     *  @apiSuccessExample {json} 返回样例:
     *  1
     */
    @PostMapping("/user")
    public int save(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    /**
     * @api {GET} /user/:id 获取用户
     * @apiName GetUser
     * @apiGroup Users
     * @apiVersion 0.0.1-SNAPSHOT
     * @apiDescription 用于通过主键查询用户
     * @apiParam {Number} id 用户主键
     * @apiParamExample {json}  请求样例：
     *  {
     *      "id":1
     *  }
     * @apiSuccessExample {json} 返回样例:
     *                {"id":1,"username":"arthursong","email":"arthurdev@163.com","password":"123456","age":18}
     */
    @GetMapping("/user/{id}")
    public User get(@PathVariable Long id){
        return userService.get(id);
    }

    /**
     * @api {DELETE} /user/:id 删除用户
     * @apiName DeleteUser
     * @apiGroup Users
     * @apiVersion 0.0.1-SNAPSHOT
     * @apiDescription 用于通过主键删除用户
     * @apiParam {Number} id 用户主键
     * @apiParamExample {json}  请求样例：
     *  {
     *      "id":1
     *  }
     * @apiSuccessExample {json} 返回样例:
     *                {"id":1,"username":"arthursong","email":"arthurdev@163.com","password":"123456","age":18}
     */
    @DeleteMapping("/user/{id}")
    public void remove(@PathVariable Long id){
        userService.remove(id);
    }

    @GetMapping("/user/byUsernameOrEmail")
    public User getByUsernameOrEmail(String keyword){
        return userService.getByUsernameOrEmail(keyword);
    }
}
