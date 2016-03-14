package com.amayadream.shiro.dao;

import com.amayadream.shiro.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author :  Amayadream
 * @date :  2016.03.12 15:38
 */
@Service(value = "userDao")
public interface IUserDao {
    List<User> selectAll(@Param("start") int start, @Param("end") int end);
    User selectByUserid(String userid);
    User count();
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String userid);
}
