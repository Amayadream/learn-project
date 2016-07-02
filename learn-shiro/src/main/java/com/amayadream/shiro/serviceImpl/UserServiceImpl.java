package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.model.User;
import com.amayadream.shiro.service.IUserService;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.07.01 21:28
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired private MongoTemplate template;

    @Override
    public List<User> list() {
        return template.findAll(User.class);
    }

    @Override
    public User selectByUserId(String userId) {
        return template.findById(userId, User.class);
    }

    @Override
    public int insertUser(User user) {
        try {
            template.insert(user);
            return 1;
        } catch (Exception e){
            return -1;
        }
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        WriteResult result = template.remove(user);
        return Integer.parseInt(result.toString());
    }
}
