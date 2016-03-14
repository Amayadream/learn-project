package com.amayadream.shiro.dao;

import com.amayadream.shiro.pojo.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 15:49
 */
@Service(value = "resourceDao")
public interface IResourceDao {
    List<Resource> selectAll();
    Resource selectById(String id);
    List<Resource> selectByPid(String parentId);
    boolean insert(Resource resource);
    boolean update(Resource resource);
    boolean delete(String id);
}
