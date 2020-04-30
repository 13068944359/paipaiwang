package com.paipaiwang.dao;

import java.util.List;

import com.paipaiwang.po.Admin;
import com.paipaiwang.po.Page;

public interface AdminMapper {
    int deleteByPrimaryKey(String username);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    
    
    List<Admin> selectPageList(Page page);
    
    int selectPageCount(Page page);
    
}