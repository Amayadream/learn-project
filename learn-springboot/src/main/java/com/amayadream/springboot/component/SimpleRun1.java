package com.amayadream.springboot.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author :  Amayadream
 * @date :  2016.04.19 22:04
 */
@Component
@Order(value = 1)
public class SimpleRun1 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("SimpleRun1 is running...");
    }
}
