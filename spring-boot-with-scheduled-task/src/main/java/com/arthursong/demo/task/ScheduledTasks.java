package com.arthursong.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/12.
 */
@Slf4j
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private int count=0;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

    /**
     * cron接受cron表达式，根据cron表达式确定定时规则
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void testCron() {
        log.info("===Cron: 第{}次执行方法", count++);
    }

}
