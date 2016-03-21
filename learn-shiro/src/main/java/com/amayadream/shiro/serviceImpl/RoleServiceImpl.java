package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.dao.IRoleDao;
import com.amayadream.shiro.pojo.Role;
import com.amayadream.shiro.service.IResourceService;
import com.amayadream.shiro.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 18:42
 */
@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {

    @Resource private IRoleDao roleDao;
    @Resource private IResourceService resourceService;

    @Override
    public List<Role> selectAll(int page, int pageSize) {
        int start = 1;
        int end = pageSize;
        if(page != 1) {
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return roleDao.selectAll(start, end);
    }

    @Override
    public Role selectByRoleId(String id) {
        return roleDao.selectByRoleId(id);
    }

    @Override
    public Role count(int pageSize) {
        return roleDao.count();
    }

    @Override
    public boolean insert(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public boolean update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public boolean delete(String id) {
        return roleDao.delete(id);
    }

    @Override
    public Set<String> findRoles(String[] roleIds) {
        if (roleIds != null) {
            Set<String> roles = new HashSet<String>();
            for (String roleId : roleIds) {
                Role role = selectByRoleId(roleId);
                if (role != null) {
                    roles.add(role.getRoleName());
                }
            }
            return roles;
        } else {
            return null;
        }
    }

    @Override
    public Set<String> findPermissions(String[] roleIds) {
        if (roleIds != null) {
            Set<String> resourceIds = new HashSet<String>();
            for (String roleId : roleIds) {
                Role role = selectByRoleId(roleId);
                if (role != null) {
                    String[] resource_ids = role.getResource_ids().split(",");
                    if (resource_ids != null) {
                        for (String resource_id : resource_ids) {
                            resourceIds.add(resource_id);
                        }
                    }
                }
            }
            return resourceService.findPermissions(resourceIds);
        } else {
            return null;
        }
    }
}
