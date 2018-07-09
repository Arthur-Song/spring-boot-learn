package com.arthursong.demo.mapper;

import com.arthursong.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(username, email, password, age) values(#{username}, #{email}, #{password}, #{age})")
    int add(User user);

    @Update("update user set username = #{username}, email = #{email}, password = #{password}, age = #{age} where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{id}")
    int delete(Long id);

    @Select("select id, username, email, password, age from user where id = #{id}")
    User get(@Param("id") Long id);

    @Select("select id, username, email, password, age from user")
    List<User> findList();

    User getByUsernameOrEmail(String keyword);
}
