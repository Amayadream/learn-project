package com.amayadream.shiro.service;

import com.amayadream.shiro.model.Resource;

import java.util.List;
import java.util.Set;

/**
 * 资源服务接口
 * @author :  Amayadream
 * @date :  2016.07.02 12:07
 */
public interface IResourceService {

    /**
     * 查询全部资源
     * @return
     */
    List<Resource> findAll();

    /**
     * 根据资源id查询特定的资源
     * @param resourceId
     * @return
     */
    Resource findOne(String resourceId);

    /**
     * 根据资源列表获取到对应的资源权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<String> resourceIds);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<Resource> findMenus(Set<String> permissions);

    /**
     * 创建资源
     * @param resource
     * @return
     */
    Resource createResource(Resource resource);

    /**
     * 更新资源
     * @param resource
     * @return
     */
    Resource updateResource(Resource resource);

    /**
     * 删除资源
     * @param resourceId
     * @return
     */
    int deleteResource(String resourceId);
}
