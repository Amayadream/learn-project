package com.amayadream.shiro.shiro.taglib;

import com.amayadream.shiro.pojo.Organization;
import com.amayadream.shiro.pojo.Resource;
import com.amayadream.shiro.pojo.Role;
import com.amayadream.shiro.service.IOrganizationService;
import com.amayadream.shiro.service.IResourceService;
import com.amayadream.shiro.service.IRoleService;
import com.amayadream.shiro.shiro.spring.SpringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class Functions {

    public static boolean in(Iterable iterable, Object element) {
        if(iterable == null) {
            return false;
        }
        return CollectionUtils.contains(iterable.iterator(), element);
    }

    public static String organizationName(String organizationId) {
        Organization organization = getOrganizationService().selectById(organizationId);
        if(organization == null) {
            return "";
        }
        return organization.getName();
    }

    public static String organizationNames(Collection<String> organizationIds) {
        if(CollectionUtils.isEmpty(organizationIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(String organizationId : organizationIds) {
            Organization organization = getOrganizationService().selectById(organizationId);
            if(organization == null) {
                return "";
            }
            s.append(organization.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }
    public static String roleName(String roleId) {
        Role role = getRoleService().selectByRoleId(roleId);
        if(role == null) {
            return "";
        }
        return role.getDescription();
    }

    public static String roleNames(Collection<String> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(String roleId : roleIds) {
            Role role = getRoleService().selectByRoleId(roleId);
            if(role == null) {
                return "";
            }
            s.append(role.getDescription());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }
    public static String resourceName(String resourceId) {
        Resource resource = getResourceService().selectById(resourceId);
        if(resource == null) {
            return "";
        }
        return resource.getName();
    }
    public static String resourceNames(Collection<String> resourceIds) {
        if(CollectionUtils.isEmpty(resourceIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(String resourceId : resourceIds) {
            Resource resource = getResourceService().selectById(resourceId);
            if(resource == null) {
                return "";
            }
            s.append(resource.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }

    private static IOrganizationService organizationService;
    private static IRoleService roleService;
    private static IResourceService resourceService;

    public static IOrganizationService getOrganizationService() {
        if(organizationService == null) {
            organizationService = SpringUtils.getBean(IOrganizationService.class);
        }
        return organizationService;
    }

    public static IRoleService getRoleService() {
        if(roleService == null) {
            roleService = SpringUtils.getBean(IRoleService.class);
        }
        return roleService;
    }

    public static IResourceService getResourceService() {
        if(resourceService == null) {
            resourceService = SpringUtils.getBean(IResourceService.class);
        }
        return resourceService;
    }
}

