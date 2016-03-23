package com.amayadream.spring.ch1.service;

import com.amayadream.spring.ch1.bean.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  Amayadream
 * @date :  2016.03.23 18:37
 */
public class UserService {
    private Map<Integer, User> users = new HashMap<>();
    {
        users.put(1, new User(1, "Amaydream"));
        users.put(2, new User(2, "Jack"));
    }

    @Cacheable(value = "users")
    public User getUser(int id){
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }
}
