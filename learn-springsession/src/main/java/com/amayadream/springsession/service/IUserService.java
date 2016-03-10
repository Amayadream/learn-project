package com.amayadream.springsession.service;


import com.amayadream.springsession.pojo.User;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.05 21:38
 */
public interface IUserService {
    List<User> selectAll();
    User selectByUserid(String userid);
}
