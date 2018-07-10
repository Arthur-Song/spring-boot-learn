package com.arthursong.demo.service;

import com.arthursong.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/7/10.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception{
        User user = userService.get(1L);
        log.info("第1次获取："+user);
        user = userService.get(1L);
        log.info("第2次获取："+user);
    }
}
