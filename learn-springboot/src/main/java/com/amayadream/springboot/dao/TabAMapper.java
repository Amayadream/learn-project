package com.amayadream.springboot.dao;

import com.amayadream.springboot.model.TabA;

public interface TabAMapper {
    int deleteByPrimaryKey(String id);

    int insert(TabA record);

    int insertSelective(TabA record);

    TabA selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TabA record);

    int updateByPrimaryKey(TabA record);
}