package com.paipaiwang.dao;

import com.paipaiwang.po.Daybook;

public interface DaybookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Daybook record);

    int insertSelective(Daybook record);

    Daybook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Daybook record);

    int updateByPrimaryKey(Daybook record);
}