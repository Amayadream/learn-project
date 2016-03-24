package com.amayadream.spring.expression.main;

import com.amayadream.spring.expression.bean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author :  Amayadream
 * @date :  2016.03.24 18:54
 */
public class Main {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/amayadream/spring/expression/xml/spring.xml");
        MyBean bean = context.getBean(MyBean.class);
        System.out.println(bean.getMessage());
    }

    ExpressionParser parser;

    @Test
    public void helloworld(){
        parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello, World!'");
        String value = exp.getValue(String.class);
        System.out.println(value);
    }
}
