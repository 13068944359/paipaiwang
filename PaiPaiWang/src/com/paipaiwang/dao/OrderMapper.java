package com.paipaiwang.dao;

import java.util.List;

import com.paipaiwang.po.Order;
import com.paipaiwang.po.Page;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectPageList(Page<Order> page);
    int selectPageCount(Page<Order> page);
    
    
    List<Order> selectBuyOrderPageByUserId(Page<Order> page);
    int selectBuyOrderCountByUserId(Page<Order> page);
    

    List<Order> selectSellOrderPageByUserId(Page<Order> page);
    int selectSellOrderCountByUserId(Page<Order> page);
    
}