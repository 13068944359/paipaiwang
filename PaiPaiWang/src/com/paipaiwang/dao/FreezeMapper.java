package com.paipaiwang.dao;

import java.util.List;

import com.paipaiwang.po.Freeze;

public interface FreezeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Freeze record);

    int insertSelective(Freeze record);

    Freeze selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Freeze record);

    int updateByPrimaryKey(Freeze record);
    
    Freeze selectBaoZhengJinByUseridAndItemid(Integer userId,Integer itemId);//获取指定用户在某件商品的保证金
    List<Freeze> selectBaoZhengJinByItemId(Integer id);//获取一件商品的所有保证金的总集合
    
    Freeze selectShouXuFeiByItemId(Integer itemId);
    Freeze selectGouMaiJinByItemId(Integer itemId);
    
    int deleteAllFreezeMoneyByOrderId(Integer id);//删除订单上的所有冻结金额（收归系统所有）
    
    List<Freeze> selectAllFreezeByUserId(Integer id);//获取指定用户的所有保证金记录
    
}