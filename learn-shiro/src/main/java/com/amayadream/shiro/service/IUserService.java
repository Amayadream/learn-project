package com.amayadream.shiro.service;

import com.amayadream.shiro.model.User;
import com.amayadream.shiro.utils.Pagination;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Set;

/**
 * 用户服务接口
 * @author :  Amayadream
 * @date :  2016.07.02 11:51
 */
public interface IUserService {

    /**
     * 查询全部用户
     * @return
     */
    List<User> findAll(Query query);

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param query
     * @return
     */
    Pagination<User> findByPage(int pageNo, int pageSize, Query query);

    /**
     * 根据用户名查询指定用户
     * @param userId
     * @return
     */
    User findByUserId(String userId);

    /**
     * 根据用户名查询角色
     * @param userId
     * @return
     */
    Set<String> findRoles(String userId);

    /**
     * 根据用户名查询其权限
     * @param userId
     * @return
     */
    Set<String> findPermission(String userId);

    /**
     * 创建用户
     * @return
     */
    User createUser(User user);

    /**
     * 更新用户
     * @return
     */
    User updateUser(User user);

    /**
     * 删除用户
     * @return
     */
    int deleteUser(String userId);

    /**
     * 更新密码
     * @return
     */
    int changePassword(String userId, String password);

}
