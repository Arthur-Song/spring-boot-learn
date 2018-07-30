package com.arthursong.demo.dao;

import com.arthursong.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/7/27.
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}