package com.arthursong.demo.service;

import com.arthursong.demo.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/7/27.
 */
@Service
public class BlogService {

    private List<Blog> list = new ArrayList<>();

    public BlogService(){
        list.add(new Blog(1L,"spring boot","spring boot is very nice !"));
        list.add(new Blog(2L,"spring cloud","spring cloud is very nice !"));
    }

    public List<Blog> list(){
        return list;
    }

    public void deleteById(Long id){
        if(id == null){
            return;
        }
        Iterator<Blog> iterator = list.iterator();
        while (iterator.hasNext()){
            Blog blog = iterator.next();
            if(blog.getId() == id){
                iterator.remove();
                return;
            }
        }
    }
}
