package com.arthursong.demo.controller;

import com.arthursong.demo.entity.dto.ResultDto;
import com.arthursong.demo.entity.form.UserForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Administrator on 2018/7/18.
 */
@RestController
public class UserController {

    @PostMapping("/register")
    public ResultDto register(@RequestBody @Valid UserForm userForm, BindingResult bindingResult){
        return ResultDto.ok(userForm);
    }
}
