package com.amayadream.spring.cache.main;

import com.amayadream.spring.cache.bean.User;
import com.amayadream.spring.cache.service.UserService;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/amayadream/spring/cache/xml/spring.xml");
        UserService userService = context.getBean(UserService.class);
        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser(1);
        System.out.println(userFetch2);
    }
}
