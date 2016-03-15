package com.amayadream.springsession.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 启用RedisHttpSession功能，并向Spring容器中注册一个RedisConnectionFactory
 * @EnableRedisHttpSession 注释创建一个Spring Bean的名称 springSessionRepositoryFilter
 * @author :  Amayadream
 * @date :  2016.03.15 19:46
 */
//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 7200)
//public class RedisSessionConfig {
//
////    /**
////     * 定义redis参数,向Spring容器中注册一个RedisConnectionFactory
////     * @return
////     */
////    @Bean
////    public RedisConnectionFactory connectionFactory() {
////        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
////        connectionFactory.setPort(6379);
////        connectionFactory.setHostName("127.0.0.1");
////        return connectionFactory;
////    }
//
//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();  // <2>
//    }
//
//    /**
//     * 使用http头信息
//     * @return
//     */
//    @Bean
//    public HttpSessionStrategy httpSessionStrategy() {
//        return new HeaderHttpSessionStrategy();
//    }
//
//
//}
