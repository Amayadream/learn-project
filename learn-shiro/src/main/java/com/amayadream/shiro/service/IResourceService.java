package com.amayadream.shiro.service;

import com.amayadream.shiro.pojo.Resource;

import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 18:32
 */
public interface IResourceService {
    List<Resource> selectAll();
    Resource selectById(String id);
    List<Resource> selectByPid(String parentId);
    boolean insert(Resource resource);
    boolean update(Resource resource);
    boolean delete(String id);

    Set<String> findPermissions(Set<String> resourceIds);
    List<Resource> findMenus(Set<String> permissions);
}
