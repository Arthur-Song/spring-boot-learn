package com.arthursong.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/7/5.
 */
@Data
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Integer age;
}
