package com.amayadream.test.dao;

import com.amayadream.test.model.B;

public interface BMapper {
    int deleteByPrimaryKey(String bid);

    int insert(B record);

    int insertSelective(B record);

    B selectByPrimaryKey(String bid);

    int updateByPrimaryKeySelective(B record);

    int updateByPrimaryKey(B record);
}