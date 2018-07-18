package com.arthursong.demo.entity;

import lombok.Data;

/**
 * Created by Administrator on 2018/7/18.
 */
@Data
public class ErrorInfo<T> {
    private Integer code;
    private String message;
    private String url;
    private T data;
}
