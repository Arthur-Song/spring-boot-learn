package com.arthursong.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 用户
 * Created by Administrator on 2018/7/3.
 */
@ToString(exclude = {"password"})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Date birthday;
}
