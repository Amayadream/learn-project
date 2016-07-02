package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.model.Role;
import com.amayadream.shiro.service.IResourceService;
import com.amayadream.shiro.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 12:12
 */
@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IResourceService resourceService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Role> findAll() {
        return mongoTemplate.findAll(Role.class);
    }

    @Override
    public Role findOne(String roleId) {
        return mongoTemplate.findById(roleId, Role.class);
    }

    @Override
    public Set<String> findRoles(String... roleIds) {
        Set<String> set = new HashSet<String>();
        for (String roleId : roleIds) {
            Role role = findOne(roleId);
            if (role != null) {
                set.add(role.getRoleId());
            }
        }
        return set;
    }

    @Override
    public Set<String> findPermissions(String[] roleIds) {
        Set<String> set = new HashSet<String>();
        for (String roleId : roleIds) {
            Role role = findOne(roleId);
            if (role != null) {
                set.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(set);
    }

    @Override
    public Role createRole(Role role) {
        mongoTemplate.insert(role);
        return mongoTemplate.findById(role.getRoleId(), Role.class);
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }

    @Override
    public int deleteRole(String roleId) {
        return 0;
    }
}
