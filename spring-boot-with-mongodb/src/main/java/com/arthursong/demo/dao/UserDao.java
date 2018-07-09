package com.arthursong.demo.dao;

import com.arthursong.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.
 */
@Repository
public class UserDao {
    /**
     * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查找全部
     */
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    /**
     * 根据id得到对象
     */
    public User getUser(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), User.class);
    }

    /**
     * 插入一个用户
     */
    public void insert(User user) {
        mongoTemplate.insert(user);
    }

    /**
     * 根据id删除一个用户
     */
    public void remove(String id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query,User.class);
    }

    /**
     * 分页查找
     *
     * user代表过滤条件
     *
     * pageable代表分页bean
     */
    public List<User> findByPage(User user, Pageable pageable) {
        Query query = new Query();
        if (user != null && user.getUsername() != null) {
            //模糊查询
            query = new Query(Criteria.where("name").regex("^" + user.getUsername()));
        }
        List<User> list = mongoTemplate.find(query.with(pageable), User.class);
        return list;
    }

    /**
     * 根据id更新
     */
    public void update(User user) {
        Criteria criteria = Criteria.where("_id").is(user.getId());
        Query query = new Query(criteria);
        Update update = Update.update("username", user.getUsername())
                .set("email", user.getEmail())
                .set("password",user.getPassword());
        mongoTemplate.updateMulti(query, update, User.class);
    }

    /**
     * 插入一个集合
     */
    public void insertAll(List<User> users) {
        mongoTemplate.insertAll(users);
    }
}
