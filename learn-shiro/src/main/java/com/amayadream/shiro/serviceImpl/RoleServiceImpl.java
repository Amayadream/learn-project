package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.model.Role;
import com.amayadream.shiro.service.IResourceService;
import com.amayadream.shiro.service.IRoleService;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        Update update = new Update();
        if(!StringUtils.isEmpty(role.getRoleName()))
            update.set("roleName", role.getRoleName());
        if(!StringUtils.isEmpty(role.getResourceIds()))
            update.set("resourceIds", role.getResourceIds());
        if(!StringUtils.isEmpty(role.getState()))
            update.inc("state", role.getState());
        WriteResult result = mongoTemplate.updateFirst(
                new Query(Criteria.where("userId").is(role.getRoleId())),
                update,
                Role.class);
        return mongoTemplate.findById(role.getRoleId(), Role.class);
    }

    @Override
    public int deleteRole(String roleId) {
        WriteResult result = mongoTemplate.remove(Query.query(Criteria.where("roleId").is(roleId)));
        return result.getN();
    }
}
