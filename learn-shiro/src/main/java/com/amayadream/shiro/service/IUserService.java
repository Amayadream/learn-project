package com.amayadream.shiro.service;

import com.amayadream.shiro.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 15:39
 */
public interface IUserService {
    List<User> selectAll(int page, int pageSize);
    User selectByUserid(String userid);
    int count(int pageSize);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String userid);

    Set<String> findRoles(String userid);
    Set<String> findPermission(String userid);
}
