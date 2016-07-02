package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.model.Organization;
import com.amayadream.shiro.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.07.02 12:12
 */
@Service(value = "organizationService")
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Organization> findAll() {
        return mongoTemplate.findAll(Organization.class);
    }

    @Override
    public Organization findOne(String organId) {
        return mongoTemplate.findById(organId, Organization.class);
    }

    @Override
    public Object findAllWithExclude(Organization organization) {
        return null;
    }

    @Override
    public void move(Organization source, Organization target) {

    }

    @Override
    public Organization createOrganization(Organization organization) {
        mongoTemplate.insert(organization);
        return mongoTemplate.findById(organization.getOrganId(), Organization.class);
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return null;
    }

    @Override
    public int deleteOrganization(String organId) {
        return 0;
    }
}
