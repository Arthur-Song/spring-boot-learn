package com.arthursong.demo.entity.dto;

import com.arthursong.demo.entity.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018/7/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {
    private Integer code;
    private String message;
    private Object data;


    private static ResultDto build(Integer code,String message,Object data){
        return new ResultDto(code,message,data);
    }

    /**
     * success
     * @param data
     * @return
     */
    public static ResultDto ok(Object data){
        return build(ResultCodeEnum.SUCCESS.getCode(),"OK",data);
    }

    /**
     * success
     * @return
     */
    public static ResultDto ok(){
        return ok(null);
    }

    /**
     * fail
     * @param message
     * @param data
     * @return
     */
    public static ResultDto fail(String message,Object data){
        return build(ResultCodeEnum.FAIL.getCode(),message,data);
    }

    /**
     * fail
     * @param message
     * @return
     */
    public static ResultDto fail(String message){
        return fail(message,null);
    }

}
