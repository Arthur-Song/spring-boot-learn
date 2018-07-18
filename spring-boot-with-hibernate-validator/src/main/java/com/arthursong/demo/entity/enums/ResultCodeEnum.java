package com.arthursong.demo.entity.enums;

/**
 * Created by Administrator on 2018/7/18.
 */
public enum ResultCodeEnum {
    FAIL(0),
    SUCCESS(1);

    private Integer code;

    ResultCodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
