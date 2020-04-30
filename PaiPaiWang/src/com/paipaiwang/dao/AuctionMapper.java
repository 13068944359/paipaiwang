package com.paipaiwang.dao;

import java.util.List;

import com.paipaiwang.po.Auction;
import com.paipaiwang.po.Page;

public interface AuctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Auction record);

    int insertSelective(Auction record);

    Auction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Auction record);

    int updateByPrimaryKey(Auction record);
    
    Auction selectLastAuctionByItemId(int id);//商品最新的竞拍记录
    Auction selectLastAuctionByItemIdAndUserId(Auction a);//指定用户对商品最新的竞拍记录
    
    List<Integer> selectItemPageByUserId(Page<Auction> page);//获取用户竞拍过的商品id
    int selectItemCountByUserId(Page<Auction> page);//获取总数
}