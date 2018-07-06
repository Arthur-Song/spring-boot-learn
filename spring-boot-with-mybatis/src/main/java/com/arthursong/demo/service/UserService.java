package com.arthursong.demo.service;

import com.arthursong.demo.entity.User;
import com.arthursong.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int saveOrUpdate(User user){
        if(user == null){
            return 0;
        }
        if(user.getId() == null){
            return userMapper.add(user);
        }else {
            return userMapper.update(user);
        }
    }

    public List<User> findAll(){
        return userMapper.findList();
    }

    public User get(Long id){
        if(id == null){
            return null;
        }
        return userMapper.get(id);
    }

    public void remove(Long id){
        if(id == null){
            return;
        }
        userMapper.delete(id);
    }

    public User getByUsernameOrEmail(String keyword){
        if(keyword == null || "".equals(keyword)){
            return null;
        }
        return userMapper.getByUsernameOrEmail(keyword);
    }
}
