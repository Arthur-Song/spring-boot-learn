package com.arthursong.demo.service;

import com.arthursong.demo.dao.UserDao;
import com.arthursong.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User getUser(String id) {
        if(id == null || "".equals(id)){
            return null;
        }
        return userDao.getUser(id);
    }

    public void update(User user) {
        if(user == null || user.getId() == null || "".equals(user.getId())){
            return;
        }
        userDao.update(user);
    }

    public void insert(User user) {
        if(user == null){
            return;
        }
        userDao.insert(user);
    }

    public void insertAll(List<User> users) {
        if(users == null || users.size() == 0){
            return;
        }
        userDao.insertAll(users);
    }

    public void remove(String id) {
        if(id == null || "".equals(id)){
            return;
        }
        userDao.remove(id);
    }

    public List<User> findByPage(User user, Pageable pageable) {
        return userDao.findByPage(user, pageable);
    }
}
