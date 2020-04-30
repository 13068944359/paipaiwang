package com.paipaiwang.dao;

import java.util.Date;
import java.util.List;

import com.paipaiwang.po.Item;
import com.paipaiwang.po.Page;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
    
    
    
    List<Item> selectUnverifyPageList(Page<Item> page);
    int selectUnverifyPageCount(Page<Item> page);

    List<Item> selectVerifiedPageList(Page<Item> page);
    int selectVerifiedPageCount(Page<Item> page);
    
    List<Item> selectPublishedPageListByOwnerId(Page<Item> page);//根据用户id获取曾经发布过的商品列表
    int selectPublishedPageCountByOwnerId(Page<Item> page);
    
    List<Item> selectHomepageItem();//获取最新发布的15个并且已经处于竞拍状态的商品
    
    
    
    //分类关键字查询相关↓
    List<Item> selectItemPageByType(Page<Item> page);
    int selectItemCountByType(Page<Item> page);
    
    List<Item> selectItemPageBySearch(Page<Item> page);
    int selectItemCountBySearch(Page<Item> page);
    
    List<Item> selectItemPageByLastDay(Page<Item> page);//分页筛选今天结束拍卖的商品
    int selectItemCountByLastDay(Page<Item> page);
    
    
    //系统定时任务
    List<Item> selectFinishAuctionBeforeToady();//筛选今天结束拍卖或者在今天之前结束拍卖的商品
    
    int updateStateTo3OnStartDate();
    
    
    //测试调用
    List<Item> selectStateEqual3();//测试调用，筛选出所有正在拍卖的商品
    
}