package com.arthursong.demo.controller;

import com.arthursong.demo.entity.Blog;
import com.arthursong.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2018/7/27.
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 获取文章列表
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {

        List<Blog> list =blogService.list();
        model.addAttribute("blogsList", list);
        return new ModelAndView("blogs/list", "blogModel", model);
    }

    /**
     * 根据id删除文章
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  //
    @GetMapping(value = "/{id}/deletion")
    public ModelAndView delete(@PathVariable("id") Long id, Model model) {
        blogService.deleteById(id);
        model.addAttribute("blogsList", blogService.list());
        return new ModelAndView("blogs/list", "blogModel", model);
    }
}
