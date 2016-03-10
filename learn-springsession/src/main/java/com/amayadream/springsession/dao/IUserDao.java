package com.amayadream.springsession.dao;

import com.amayadream.springsession.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.05 21:37
 */
@Service(value = "userDao")
public interface IUserDao {
    List<User> selectAll();
    User selectByUserid(String userid);
}
