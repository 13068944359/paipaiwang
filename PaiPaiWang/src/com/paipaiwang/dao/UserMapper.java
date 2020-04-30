package com.paipaiwang.dao;

import java.util.List;

import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectPageList(Page<User> page);
    
    int selectPageCount(Page<User> page);
    
    User selectByMobilephone(String mobile);
}