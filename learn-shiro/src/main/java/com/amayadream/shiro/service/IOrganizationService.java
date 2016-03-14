package com.amayadream.shiro.service;

import com.amayadream.shiro.pojo.Organization;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 18:32
 */
public interface IOrganizationService {
    List<Organization> selectAll();
    Organization selectById();
    List<Organization> selectByPid(String parentId);
    boolean insert(Organization organization);
    boolean update(Organization organization);
    boolean delete(String id);

    Object findAllWithExclude(Organization organization);
    void move(Organization source, Organization target);
}
