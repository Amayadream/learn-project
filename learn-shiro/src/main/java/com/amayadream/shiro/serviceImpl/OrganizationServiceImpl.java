package com.amayadream.shiro.serviceImpl;

import com.amayadream.shiro.model.Organization;
import com.amayadream.shiro.service.IOrganizationService;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        Update update = new Update();
        if(!StringUtils.isEmpty(organization.getOrganName()))
            update.set("organName", organization.getOrganName());
        if(!StringUtils.isEmpty(organization.getParentId()))
            update.set("parentId", organization.getParentId());
        if(!StringUtils.isEmpty(organization.getParentIds()))
            update.set("parentIds", organization.getParentIds());
        if(!StringUtils.isEmpty(organization.getState()))
            update.inc("state", organization.getState());
        WriteResult result = mongoTemplate.updateFirst(
                new Query(Criteria.where("organId").is(organization.getOrganId())),
                update,
                Organization.class
        );
        return mongoTemplate.findById(organization.getOrganId(), Organization.class);
    }

    @Override
    public int deleteOrganization(String organId) {
        WriteResult result = mongoTemplate.remove(Query.query(Criteria.where("organId").is(organId)));
        return result.getN();
    }
}
