package com.amayadream.shiro.service;

import com.amayadream.shiro.model.Role;

import java.util.List;
import java.util.Set;

/**
 * 角色服务接口
 * @author :  Amayadream
 * @date :  2016.07.02 11:56
 */
public interface IRoleService {

    /**
     * 查询全部角色
     * @return
     */
    List<Role> findAll();

    /**
     * 根据角色id查询特定角色
     * @param roleId
     * @return
     */
    Role findOne(String roleId);

    /**
     * 根据角色id查询角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> findRoles(String... roleIds);

    /**
     * 根据角色id获取权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(String[] roleIds);

    /**
     * 创建角色
     * @param role
     * @return
     */
    Role createRole(Role role);

    /**
     * 更新角色
     * @param role
     * @return
     */
    Role updateRole(Role role);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    int deleteRole(String roleId);

}
