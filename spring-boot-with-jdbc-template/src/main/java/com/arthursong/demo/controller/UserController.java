package com.arthursong.demo.controller;

import com.arthursong.demo.dao.UserDao;
import com.arthursong.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    /**
     * 用户列表
     * @return
     */
    @RequestMapping("/list")
    public List<User> listUser() {
        List<User> userList=null;
        try {
            userList=userDao.getUserList();
        }catch (Exception e){
            System.out.println("异常信息:  "+e.getMessage());
        }
        return userList;
    }

    /**
     * 根据id查询User实体
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        User user=null;
        try {
            user=userDao.getUserById(id);
        }catch (Exception e){
            user=new User();
            System.out.println("异常信息： "+e.getMessage());
        }
        return user;
    }

    /**
     * 保存user实体
     * @param user
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public int insertUser(User user){
        int res=1;
        try {
            res=userDao.saveUser(user);
        }catch (Exception e){
            System.out.println("异常信息： "+e.getMessage());
        }
        return res;
    }

    /**
     * 保存User实体-PreparedStatementSetter
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveWithSafe",method = RequestMethod.POST)
    public int insertUserWithSafe(User user){
        int res=1;
        try {
            res=userDao.saveUserWithSafe(user);
        }catch (Exception e){
            System.out.println("异常信息： "+e.getMessage());
        }
        return res;
    }

    /**
     * 保存user实体-PreparedStatementCreator、KeyHolder-保存实体后返回实体的主键
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveWithKey",method = RequestMethod.POST)
    public int insertUserWithKey(User user){
        int res=1;
        try {
            res=userDao.saveUserWithKey(user);
        }catch (Exception e){
            System.out.println("异常信息： "+e.getMessage());
        }
        return res;
    }

    /**
     * 根据id更新user实体
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public int updateUserWithId(User user){
        int res=1;
        try {
            if (user.getId()!=null && !user.getId().equals(0)){
                res=userDao.updateUser(user);
            }
        }catch (Exception e){
            System.out.println("异常信息： "+e.getMessage());
        }
        return res;
    }

    /**
     * 根据id删除user实体
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public int deleteUserById(@PathVariable Integer id){
        int res=1;
        try {
            User deleteUser=userDao.getUserById(id);
            res=userDao.deleteUser(deleteUser);
        }catch (Exception e){
            System.out.println("异常信息： "+e.getMessage());
        }
        return res;
    }

    /**
     * 根据username查询是否存在某个user实体
     * @param username
     * @return
     */
    @RequestMapping("/isExistUser")
    public Boolean isExistUser(String username){
        Boolean res=false;
        try {
            User queryUser=new User(null,username,null,null,new Date());
            User deleteUser=userDao.getUserByUserName(queryUser);
            if (deleteUser!=null){
                res=true;
            }
        }catch (Exception e){
            System.out.println("异常信息： "+e.getMessage());
        }
        return res;
    }

    /**
     * 查询user实体的总数
     * @return
     */
    @RequestMapping("/total")
    public Integer getTotal(){
        Integer res=0;
        try {
            res=userDao.getCount();
        }catch (Exception e){
            System.out.println("异常信息： "+e.getMessage());
        }
        return res;
    }

}
