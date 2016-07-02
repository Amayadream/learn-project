package com.amayadream.shiro.service;

import com.amayadream.shiro.model.User;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.07.01 21:26
 */
public interface IUserService {

    List<User> list();

    User selectByUserId(String userId);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);

}
