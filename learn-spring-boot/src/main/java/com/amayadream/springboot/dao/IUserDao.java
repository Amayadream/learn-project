package com.amayadream.springboot.dao;

import com.amayadream.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author :  Amayadream
 * @date :  2016.03.12 15:38
 */
@Service(value = "userDao")
public interface IUserDao {
    List<User> selectAll();
}
