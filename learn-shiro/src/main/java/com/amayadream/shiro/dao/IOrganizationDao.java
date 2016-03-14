package com.amayadream.shiro.dao;

import com.amayadream.shiro.pojo.Organization;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author :  Amayadream
 * @date :  2016.03.14 15:49
 */
@Service(value = "organizationDao")
public interface IOrganizationDao {
    List<Organization> selectAll();
    Organization selectById();
    List<Organization> selectByPid(String parentId);
    boolean insert(Organization organization);
    boolean update(Organization organization);
    boolean delete(String id);

}
