package com.arthursong.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Administrator on 2018/7/6.
 */
@Data
@ToString
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Integer age;
}
