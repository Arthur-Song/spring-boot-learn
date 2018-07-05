package com.arthursong.demo.repository;

import com.arthursong.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testDefaultFuncs(){
        User user = new User();
        user.setName("Arthur");
        user.setEmail("arthurdev@163.com");
        user.setAge(18);

        User userSaved = userRepository.save(user);
        log.info(userSaved.toString());
        Assert.assertNotNull(userSaved.getId()); //判断id不为空

        List<User> list = userRepository.findAll();
        log.info(list.toString());
        Assert.assertTrue(list != null && list.size() > 0);

        User userFindByOne = userRepository.findOne(userSaved.getId());
        log.info(userFindByOne.toString());
        Assert.assertNotNull(userFindByOne);

        Long count = userRepository.count();
        log.info(count.toString());
        Assert.assertTrue(count == 1);

        boolean exists = userRepository.exists(userSaved.getId());
        log.info(exists+"");
        Assert.assertTrue(exists);

        userRepository.delete(userSaved);
        //...

    }

    @Test
    public void testPageQuery() throws Exception {
        int page=1,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        userRepository.findALL(pageable);
        userRepository.findByName("Arthur", pageable);
    }
}
