package com.amayadream.springboot.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author :  Amayadream
 * @date :  2016.04.19 22:04
 */
@Component
@Order(value = 2)
public class SimpleRun2 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("SimpleRun2 is running...");
    }
}
