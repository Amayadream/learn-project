package com.amayadream.java.reflect;

import org.junit.Test;

/**
 * @author :  Amayadream
 * @date :  2016.03.29 22:18
 */
public class ReflectDemo {

    @Test
    public void reflectdemo(){
        ReflectDemo demo = new ReflectDemo();
        System.out.printf(demo.getClass().getName());
    }

}
