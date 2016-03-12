package com.amayadream.shiro.service;

import com.amayadream.shiro.pojo.User;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 15:39
 */
public interface IUserService {
    List<User> selectAll();
    User selectByUserid(String userid);
}
