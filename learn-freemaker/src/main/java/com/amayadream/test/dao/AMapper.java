package com.amayadream.test.dao;

import com.amayadream.test.model.A;

public interface AMapper {
    int deleteByPrimaryKey(String aid);

    int insert(A record);

    int insertSelective(A record);

    A selectByPrimaryKey(String aid);

    int updateByPrimaryKeySelective(A record);

    int updateByPrimaryKey(A record);
}