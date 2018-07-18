package com.arthursong.demo.controller;

import com.arthursong.demo.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/7/18.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() throws Exception{
        throw new Exception("Error");
    }

    @GetMapping("/business")
    public String business() throws Exception{
        throw new BusinessException(23,"业务错误");
    }
}
