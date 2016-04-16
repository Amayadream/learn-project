package com.amayadream.test.dao;

import com.amayadream.test.model.C;

public interface CMapper {
    int deleteByPrimaryKey(String cid);

    int insert(C record);

    int insertSelective(C record);

    C selectByPrimaryKey(String cid);

    int updateByPrimaryKeySelective(C record);

    int updateByPrimaryKey(C record);
}