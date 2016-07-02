package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.model.Resource;
import com.amayadream.shiro.service.IResourceService;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 12:12
 */
@Service(value = "resourceService")
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Resource> findAll() {
        return mongoTemplate.findAll(Resource.class);
    }

    @Override
    public Resource findOne(String resourceId) {
        return mongoTemplate.findById(resourceId, Resource.class);
    }

    @Override
    public Set<String> findPermissions(Set<String> resourceIds) {
        Set<String> set = new HashSet<String>();
        for (String resourceId : resourceIds) {
            Resource resource = findOne(resourceId);
            if (resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                set.add(resource.getPermission());
            }
        }
        return set;
    }

    @Override
    public List<Resource> findMenus(Set<String> permissions) {
        List<Resource> allResources = findAll();
        List<Resource> menus = new ArrayList<Resource>();
        for (Resource resource : allResources) {
            if (resource.isRootNode()) {
                continue;
            }
            if (!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, Resource resource) {
        if (StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for (String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if (p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Resource createResource(Resource resource) {
        return null;
    }

    @Override
    public Resource updateResource(Resource resource) {
        return null;
    }

    @Override
    public int deleteResource(String resourceId) {
        return 0;
    }
}
