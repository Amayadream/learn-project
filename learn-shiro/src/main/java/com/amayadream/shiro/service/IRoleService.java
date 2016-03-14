package com.amayadream.shiro.service;

import com.amayadream.shiro.pojo.Role;

import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 18:31
 */
public interface IRoleService {
    List<Role> selectAll(int page, int pageSize);
    Role selectByRoleId(String id);
    Role count(int pageSize);
    boolean insert(Role role);
    boolean update(Role role);
    boolean delete(String id);
    Set<String> findRoles(String[] roleIds);
    Set<String> findPermissions(String[] roleIds);
}
