package com.arthursong.demo.enums;

/**
 * Created by Administrator on 2018/7/10.
 */
public enum CacheEnums {
    user(60, 2);

    CacheEnums() {}

    CacheEnums(int duration) {
        this.duration = duration;
    }

    CacheEnums(int duration, int maxSize) {
        this.duration = duration;
        this.maxSize = maxSize;
    }

    /**
     * 最大數量
     */
    private int maxSize;
    /**
     * 缓存时间
     */
    private int duration;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
