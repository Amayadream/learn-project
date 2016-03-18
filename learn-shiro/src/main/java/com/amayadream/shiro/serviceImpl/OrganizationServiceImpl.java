package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.dao.IOrganizationDao;
import com.amayadream.shiro.pojo.Organization;
import com.amayadream.shiro.service.IOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 18:43
 */
@Service(value = "organizationService")
public class OrganizationServiceImpl implements IOrganizationService {

    @Resource private IOrganizationDao organizationDao;

    @Override
    public List<Organization> selectAll() {
        return organizationDao.selectAll();
    }

    @Override
    public Organization selectById(String id) {
        return organizationDao.selectById(id);
    }

    @Override
    public List<Organization> selectByPid(String parentId) {
        return organizationDao.selectByPid(parentId);
    }

    @Override
    public boolean insert(Organization organization) {
        return organizationDao.insert(organization);
    }

    @Override
    public boolean update(Organization organization) {
        return organizationDao.update(organization);
    }

    @Override
    public boolean delete(String id) {
        return organizationDao.delete(id);
    }

//    @Override
//    public Object findAllWithExclude(Organization organization) {
//        return organizationDao.findAllWithExclude(organization);
//    }
//
//    @Override
//    public void move(String sourceId, String targetId, String targetParentIds) {
//        organizationDao.move(sourceId, targetId, targetParentIds);
//    }
}
