package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.dao.IUserDao;
import com.amayadream.shiro.pojo.User;
import com.amayadream.shiro.service.IRoleService;
import com.amayadream.shiro.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author :  Amayadream
 * @date :  2016.03.12 15:40
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Resource private IUserDao userDao;
    @Resource private IRoleService roleService;

    @Override
    public List<User> selectAll(int page, int pageSize) {
        int start = 1;
        int end = pageSize;
        if(page != 1) {
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return userDao.selectAll(start, end);
    }

    @Override
    public List<User> selectAllNoPage() {
        return userDao.selectAllNoPage();
    }

    @Override
    public User selectByUserid(String userid) {
        return userDao.selectByUserid(userid);
    }

    @Override
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(String userid) {
        return userDao.delete(userid);
    }

    @Override
    public int count(int pageSize) {
        int pageCount = Integer.parseInt(userDao.count().getUserid());
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
    }

    @Override
    public Set<String> findRoles(String userid) {
        try {
            User user = userDao.selectByUserid(userid);
            if (user == null) {
                return Collections.EMPTY_SET;
            }
            return roleService.findRoles(user.getRole_ids().split(","));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Set<String> findPermission(String userid) {
        try {
            User user = userDao.selectByUserid(userid);
            if (user == null) {
                return Collections.EMPTY_SET;
            }
            return roleService.findPermissions(user.getRole_ids().split(","));
        } catch (Exception e) {
            return null;
        }
    }
}
