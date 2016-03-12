package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.dao.IUserDao;
import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 15:40
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource private IUserDao userDao;

    public List<User> selectAll() {
        return userDao.selectAll();
    }

    public User selectByUserid(String userid) {
        return userDao.selectByUserid(userid);
    }
}
