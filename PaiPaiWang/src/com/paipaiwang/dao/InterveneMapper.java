package com.paipaiwang.dao;

import java.util.List;

import com.paipaiwang.po.Intervene;
import com.paipaiwang.po.Page;

public interface InterveneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Intervene record);

    int insertSelective(Intervene record);

    Intervene selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Intervene record);

    int updateByPrimaryKey(Intervene record);
    
    Intervene selectByOrderIdAndType(Intervene i);
    
    
    List<Intervene> selectPageList(Page<Intervene> page);
    int selectPageCount(Page<Intervene> page);
    
    
    int handleInterveneByOrderId(Integer id);
}