package com.arthursong.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/7/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Long id;
    private String name;
    private String content;
}
