package com.arthursong.demo.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 全局默认的缓存配置
 * Created by Administrator on 2018/7/10.
 */
@Configuration
@EnableCaching
public class GuavaBasicConfig {

    /**
     * 最大个数
     */
    private static final int DEFAULT_MAXSIZE = 1000;
    /**
     * 超时时间
     */
    private static final int DEFAULT_DURATION = 60;

    /**
     * 配置全局缓存参数
     */
    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(DEFAULT_DURATION, TimeUnit.SECONDS).maximumSize(DEFAULT_MAXSIZE));
        return cacheManager;
    }
}
