package com.paipaiwang.service;

import java.util.List;
import java.util.Map;

import com.paipaiwang.po.Auction;
import com.paipaiwang.po.Page;
import com.paipaiwang.user.vo.LatestAuctionVO;
import com.paipaiwang.user.vo.MyAuctionVO;

public interface AuctionService {

	public void createOrderFromFinishedAuction() throws Exception;////把当天结束拍卖的商品筛选出来，有人参与拍卖的则生成对应的订单并将商品状态改为成交（5），没人拍卖的则流拍（4）
	
	public void createOrderForTest()throws Exception;

	public void startAuctionOnItemStartDate()throws Exception;//商品的开始日期如果是今天，则将商品的state改为正在拍卖中
	
	
	
	
	
	
	
	//如果出价慢有可能会导致出价者价格在一瞬间低于当前价格，boolean用于返回出价是否及时，如果false则提示用户“手慢”
	public boolean addAuction(Auction auction) throws Exception;
	
	//支付竞拍所需的保证金
	public Boolean payAuctionFreeze(int userId,int itemId)throws Exception;
	
	//获取最新的竞拍价格和竞拍人
	public LatestAuctionVO latestAuction(int itemId)throws Exception;
	
	
	
	//获取当前用户参与过的竞拍的记录，用到了分页所以使用Page进行封装，把用户id用page中的keyword存储
	public Map<String,Object> getMyAuctionList(Page<Auction> page)throws Exception;
	
}
