package com.amayadream.shiro.service;

import com.amayadream.shiro.model.Organization;

import java.util.List;

/**
 * 组织服务接口
 * @author :  Amayadream
 * @date :  2016.07.02 12:04
 */
public interface IOrganizationService {

    /**
     * 查询全部组织
     * @return
     */
    List<Organization> findAll();

    /**
     * 根据组织id查询特定组织
     * @param organId
     * @return
     */
    Organization findOne(String organId);

    Object findAllWithExclude(Organization organization);

    void move(Organization source, Organization target);

    /**
     * 添加组织
     * @param organization
     * @return
     */
    Organization createOrganization(Organization organization);

    /**
     * 更新组织
     * @param organization
     * @return
     */
    Organization updateOrganization(Organization organization);

    /**
     * 删除组织
     * @param organId
     * @return
     */
    int deleteOrganization(String organId);
}
