package com.arthursong.demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/7/4.
 */
@Data
@Component
@PropertySource(value = "classpath:other.yml")
@ConfigurationProperties(prefix = "other")
public class Other {
    @Value("${name}")//需要使用@value注解来注入，否则是null
    private String name;
    @Value("${description}")//需要使用@value注解来注入，否则是null
    private String description;
}
