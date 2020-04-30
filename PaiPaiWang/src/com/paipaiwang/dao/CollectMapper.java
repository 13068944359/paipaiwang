package com.paipaiwang.dao;

import java.util.List;

import com.paipaiwang.po.Collect;
import com.paipaiwang.po.Page;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
    
    Collect selectByUserIdAndItemId(Collect record);
    
    
    List<Collect> selectPageByUserid(Page<Collect> page);    //分页列表
    int selectCountByUserid(Page<Collect> page);//总记录数
}