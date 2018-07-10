package com.arthursong.demo.service;

import com.arthursong.demo.entity.User;
import com.arthursong.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @CachePut(value = "user",key = "'user'.concat(#user.id.toString())")
    public int saveOrUpdate(User user){
        if(user == null){
            return 0;
        }
        log.info("saveOrUpdate:"+user);
        if(user.getId() == null){
            return userMapper.add(user);
        }else {
            return userMapper.update(user);
        }
    }

    public List<User> findAll(){
        return userMapper.findList();
    }

    @Cacheable(value = "user",key = "'user'.concat(#id.toString())")
    public User get(Long id){
        if(id == null){
            return null;
        }
        log.info("get:"+id);
        return userMapper.get(id);
    }

    @CacheEvict(value = "user",key = "'user'.concat(#id.toString())")
    public void remove(Long id){
        if(id == null){
            return;
        }
        log.info("remove:"+id);
        userMapper.delete(id);
    }

    public User getByUsernameOrEmail(String keyword){
        if(keyword == null || "".equals(keyword)){
            return null;
        }
        return userMapper.getByUsernameOrEmail(keyword);
    }
}
