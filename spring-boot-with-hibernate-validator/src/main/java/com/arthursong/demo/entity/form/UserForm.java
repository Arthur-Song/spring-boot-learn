package com.arthursong.demo.entity.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * Created by Administrator on 2018/7/18.
 */
@Data
public class UserForm {

    @NotBlank(message = "{user.username.empty}")
    @Length(min = 6,max = 25,message = "{user.username.length}")
    private String username;

    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message = "邮箱的格式不正确")
    private String email;

    @NotBlank(message = "密码不能为空")
    @Length(min = 8,max = 32,message = "密码长度必须在8-32之间")
    private String password;

    @AssertFalse(message = "注册用户不能是管理员")
    private Boolean isAdmin;

    @Min(value = 1, message = "年龄最小只能1")
    @Max(value = 120, message = "年龄最大只能120")
    private Integer age;
    /**
     * 如果是空，则不校验，如果不为空，则校验
     */
    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="出生日期格式不正确")
    private String birthday;
}
