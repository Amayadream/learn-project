package com.amayadream.shiro.dao;

import com.amayadream.shiro.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 15:38
 */
@Service(value = "userDao")
public interface IUserDao {
    List<User> selectAll();
    User selectByUserid(String userid);
}
