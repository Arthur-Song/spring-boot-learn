package com.arthursong.demo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/9.
 */
@Data
@ToString
public class User implements Serializable {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
}
