package com.arthursong.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/6.
 */
@ToString(exclude = {"password"})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable{
    private Long id;
    private String username;
    private String email;
    private String password;
}
