package com.amayadream.shiro.dao;

import com.amayadream.shiro.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.03.14 15:49
 */
@Service(value = "roleDao")
public interface IRoleDao {
    List<Role> selectAll(@Param("start") int start, @Param("end") int end);
    Role selectByRoleId(String id);
    Role count();
    boolean insert(Role role);
    boolean update(Role role);
    boolean delete(String id);
}
