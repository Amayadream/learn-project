package com.amayadream.springsession.serviceImpl;

import com.amayadream.springsession.dao.IUserDao;
import com.amayadream.springsession.pojo.User;
import com.amayadream.springsession.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author :  Amayadream
 * @date :  2016.03.05 21:39
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
