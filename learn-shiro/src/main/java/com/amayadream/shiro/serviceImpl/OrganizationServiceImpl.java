package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.pojo.Organization;
import com.amayadream.shiro.service.IOrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 18:43
 */
@Service(value = "organizationService")
public class OrganizationServiceImpl implements IOrganizationService {
    @Override
    public List<Organization> selectAll() {
        return null;
    }

    @Override
    public Organization selectById() {
        return null;
    }

    @Override
    public List<Organization> selectByPid(String parentId) {
        return null;
    }

    @Override
    public boolean insert(Organization organization) {
        return false;
    }

    @Override
    public boolean update(Organization organization) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Object findAllWithExclude(Organization organization) {
        return null;
    }

    @Override
    public void move(Organization source, Organization target) {

    }
}
