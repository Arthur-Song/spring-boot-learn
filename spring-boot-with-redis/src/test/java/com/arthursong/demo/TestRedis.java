package com.arthursong.demo;

import com.arthursong.demo.entity.User;
import com.arthursong.demo.service.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/7/6.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    private static final String key = "spring:boot:with:redis:";//这里的key值可以自己修改
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void test() throws Exception{
        User user = new User(1L,"Arthur Song","arthurdev@163.com","123456");
        //存入redis
        redisUtils.set(key.concat(user.getId().toString()),user,10L,TimeUnit.SECONDS);

        //根据key取
        Object obj = redisUtils.get( key.concat(user.getId().toString()) );
        Assert.assertNotNull(obj);
        log.info(obj.toString());

        //测试失效
        Thread.sleep(12000); //休眠12秒
        boolean exists = redisUtils.exists(key.concat(user.getId().toString()) );
        Assert.assertFalse(exists); //判断是否已经失效
        log.info(exists+"");

        //测试删除
        redisUtils.set(key.concat(user.getId().toString()),user,60L,TimeUnit.SECONDS);
        boolean hasKey = redisUtils.exists(key.concat(user.getId().toString()) );
        if(hasKey){
            redisUtils.remove(key.concat(user.getId().toString()) );

            boolean stillHasKey = redisUtils.exists(key.concat(user.getId().toString()) );
            Assert.assertFalse(stillHasKey);
            log.info(stillHasKey+"");
        }
    }
}
