package com.amayadream.springsession.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author :  Amayadream
 * @date :  2016.03.11 14:50
 */
@Component
public class Task {

    @Scheduled(cron="0 1/10 *  * * ? ")   //每5秒执行一次
    public void myTest(){
        System.out.println("进入测试");
    }
}
