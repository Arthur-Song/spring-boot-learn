package com.arthursong.demo.config;

import com.arthursong.demo.enums.CacheEnums;
import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * guava缓存配置
 * Created by Administrator on 2018/7/10.
 */
@Configuration
@EnableCaching
public class GuavaConfig {

    /**
     * 个性化配置缓存
     */
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager manager = new SimpleCacheManager();
        //把各个cache注册到cacheManager中，GuavaCache实现了org.springframework.cache.Cache接口
        ArrayList<GuavaCache> caches = new ArrayList<>();
        for (CacheEnums cacheEnums : CacheEnums.values()) {
            caches.add(
                    new GuavaCache(cacheEnums.name(), CacheBuilder.newBuilder().recordStats().expireAfterWrite(cacheEnums.getDuration(), TimeUnit.SECONDS).maximumSize(cacheEnums.getMaxSize()).build())
            );
        }
        manager.setCaches(caches);
        return manager;
    }
}
