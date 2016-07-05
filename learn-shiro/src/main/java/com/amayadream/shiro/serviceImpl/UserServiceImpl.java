package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.model.User;
import com.amayadream.shiro.service.IRoleService;
import com.amayadream.shiro.service.IUserService;
import com.amayadream.shiro.utils.Pagination;
import com.amayadream.shiro.utils.PasswordHelper;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public List<User> findAll(Query query) {
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public Pagination<User> findByPage(int pageNo, int pageSize, Query query) {
        long totalCount = mongoTemplate.count(query, User.class);
        Pagination<User> page = new Pagination<User>(pageNo, pageSize, totalCount);
        query.skip(page.getFirstResult());
        query.limit(pageSize);
        List<User> data = mongoTemplate.find(query, User.class);
        page.setDatas(data);
        return page;
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
        Update update = new Update();
        if (!StringUtils.isEmpty(user.getRoleIds()))
            update.set("roleIds", user.getRoleIds());
        if (!StringUtils.isEmpty(user.getOrganizationId()))
            update.set("organizationId", user.getOrganizationId());
        if (!StringUtils.isEmpty(user.getState()))
            update.inc("state", user.getState());
        WriteResult result = mongoTemplate.updateFirst(
                new Query(Criteria.where("userId").is(user.getUserId())),
                update,
                User.class);
        return mongoTemplate.findById(user.getUserId(), User.class);
    }

    @Override
    public int deleteUser(String userId) {
        WriteResult result = mongoTemplate.remove(new Query(Criteria.where("userId").is(userId)));
        return result.getN();
    }

    @Override
    public int changePassword(String userId, String password) {
        User user = mongoTemplate.findById(userId, User.class);
        user.setPassword(password);
        passwordHelper.encryptPassword(user);
        WriteResult result = mongoTemplate.updateFirst(
                new Query(Criteria.where("userId").is(userId)),
                new Update().set("password", user.getPassword()).set("salt", user.getSalt()),
                User.class);
        return result.getN();
    }
}
