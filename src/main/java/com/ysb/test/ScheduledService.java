package com.ysb.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    @Scheduled(cron = "0/5 28 19 * * ?")
    @Scheduled(cron = "30/2 23 19 * * ?")
    public void hello(){
        System.out.println("定时任务");
    }
}
