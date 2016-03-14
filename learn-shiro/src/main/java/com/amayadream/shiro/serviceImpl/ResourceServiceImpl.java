package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.dao.IResourceDao;
import com.amayadream.shiro.pojo.Resource;
import com.amayadream.shiro.service.IResourceService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 18:42
 */
@Service(value = "resourceService")
public class ResourceServiceImpl implements IResourceService {

    @Autowired private IResourceDao resourceDao;

    @Override
    public List<Resource> selectAll() {
        return resourceDao.selectAll();
    }

    @Override
    public Resource selectById(String id) {
        return resourceDao.selectById(id);
    }

    @Override
    public List<Resource> selectByPid(String parentId) {
        return resourceDao.selectByPid(parentId);
    }

    @Override
    public boolean insert(Resource resource) {
        return resourceDao.insert(resource);
    }

    @Override
    public boolean update(Resource resource) {
        return resourceDao.update(resource);
    }

    @Override
    public boolean delete(String id) {
        return resourceDao.delete(id);
    }

    @Override
    public Set<String> findPermissions(Set<String> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for (String resourceId : resourceIds) {
            Resource resource = selectById(resourceId);
            if (resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    @Override
    public List<Resource> findMenus(Set<String> permissions) {
        List<Resource> allResources = selectAll();
        List<Resource> menus = new ArrayList<Resource>();
        for (Resource resource : allResources) {
            if (resource.getParent_id().equals("-1")) {
                continue;
            }
            if(!resource.getType().equals("menu")){
                continue;
            }
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, Resource resource) {
        if(org.springframework.util.StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
}
