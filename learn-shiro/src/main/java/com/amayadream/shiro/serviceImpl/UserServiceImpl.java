package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.model.User;
import com.amayadream.shiro.service.IRoleService;
import com.amayadream.shiro.service.IUserService;
import com.amayadream.shiro.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 11:51
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User findByUserId(String userId) {
        return mongoTemplate.findById(userId, User.class);
    }

    @Override
    public Set<String> findRoles(String userId) {
        User user = findByUserId(userId);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(user.getRoleIds().toArray(new String[0]));
    }

    @Override
    public Set<String> findPermission(String userId) {
        User user = findByUserId(userId);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findPermissions(user.getRoleIds().toArray(new String[0]));
    }

    @Override
    public User createUser(User user) {
        passwordHelper.encryptPassword(user);
        mongoTemplate.insert(user);
        return mongoTemplate.findById(user.getUserId(), User.class);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public int deleteUser(String userId) {
        return 0;
    }

    @Override
    public int changePassword(String userId, String password) {
        return 0;
    }
}
