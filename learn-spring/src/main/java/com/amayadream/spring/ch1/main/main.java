package com.amayadream.spring.ch1.main;

import com.amayadream.spring.ch1.bean.User;
import com.amayadream.spring.ch1.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring缓存测试
 * @author :  Amayadream
 * @date :  2016.03.23 18:43
 */
public class main {

    @Test
    public void asd(){
        System.out.println(System.getProperty("user.dir"));
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/amayadream/spring/ch1/xml/spring.xml");
        UserService userService = context.getBean(UserService.class);
        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser(1);
        System.out.println(userFetch2);
    }
}
