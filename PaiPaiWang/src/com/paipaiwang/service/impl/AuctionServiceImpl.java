package com.paipaiwang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipaiwang.dao.AuctionMapper;
import com.paipaiwang.dao.FreezeMapper;
import com.paipaiwang.dao.ItemMapper;
import com.paipaiwang.dao.OrderMapper;
import com.paipaiwang.dao.UserMapper;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.po.Auction;
import com.paipaiwang.po.Freeze;
import com.paipaiwang.po.Item;
import com.paipaiwang.po.Order;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.service.AuctionService;
import com.paipaiwang.user.vo.LatestAuctionVO;
import com.paipaiwang.user.vo.MyAuctionVO;
import com.paipaiwang.utils.ArithUtil;

@Service
public class AuctionServiceImpl implements AuctionService {

	
	
	//synchronized 使用关键字防止并发问题（多用户同时提交竞拍）
	@Override
	public synchronized boolean addAuction(Auction auction) throws Exception {

		//首先确定商品id的合法性以及商品状态
		Item item = itemMapper.selectByPrimaryKey(auction.getItemId());
		if(item == null){
			throw new Exception("itemId非法");
		}
		if(item.getState() != Item.AUCTIONING){
			throw new Exception("商品并非处于拍卖中");
		}
		
		/**
		 * 还得判断参与竞拍的用户不能是该商品的发布者
		 */
		
		//判断当前用户已经支付过保证金了
		Freeze freeze = freezeMapper.selectBaoZhengJinByUseridAndItemid(auction.getUserId(), auction.getItemId());
		if(freeze == null){
			throw new Exception("尚未支付保证金");
		}
	
		Auction lastAuction = auctionMapper.selectLastAuctionByItemId(auction.getItemId());
		
		if(lastAuction == null){
			//尚未有人参与竞拍
			//判断竞拍价是否=商品价格   或者 竞拍价-商品价格 = 竞拍阶梯的正整数倍
			double sub = ArithUtil.sub( auction.getPrice() , item.getPrice() );//竞价-起拍价
			double div = ArithUtil.div(sub, item.getPriceAdd());//(竞价-起拍价)/竞拍阶梯
			//要么竞拍价=起拍价   要么两者的差是竞拍阶梯的整数倍
			if(sub == 0 || (sub > 0 && div == (int)div )){
				auctionMapper.insertSelective(auction);
				return true;
			}else{
				throw new AdminUnknowException("竞拍价有问题：" + auction.getPrice(), null);
			}
		}else{
			//已经有人参与竞拍
			double sub = ArithUtil.sub(auction.getPrice() ,  lastAuction.getPrice());//竞价-上一轮竞拍价
			double div = ArithUtil.div(sub, item.getPriceAdd());//(竞价-起拍价)/竞拍阶梯
			if(sub <= 0){
				return false;
			}else if(div == (int)div){
				//两者的差是竞拍阶梯的整数倍
				auctionMapper.insertSelective(auction);
				return true;
			}else{
				throw new AdminUnknowException("竞拍价有问题：" + auction.getPrice(), null);
			}
		}
	}
	

	//支付竞拍所需的保证金
	@Override
	public Boolean payAuctionFreeze(int userId, int itemId) throws Exception {
		//首先确定商品id的合法性以及商品状态
		Item item = itemMapper.selectByPrimaryKey(itemId);
		if(item == null){
			throw new Exception("itemId非法");
		}
		if(item.getState() != Item.AUCTIONING){
			throw new Exception("商品并非处于拍卖中");
		}
		/**
		 * 还得判断参与竞拍的用户不能是该商品的发布者（前端已经做了判断）
		 */
		//判断当前用户没有支付过该保证金，防止重复支付
		Freeze freeze = freezeMapper.selectBaoZhengJinByUseridAndItemid(userId, itemId);
		if(freeze != null){
			throw new Exception("重复支付保证金");
		}
		
		User user = userMapper.selectByPrimaryKey(userId);
		if(user.getUserMoney() < 200){
			return false;
		}else{
			double newMoney = ArithUtil.sub(user.getUserMoney(), 200);//扣除200元
			User newUser = new User();
			newUser.setId(user.getId());
			newUser.setUserMoney(newMoney);
			userMapper.updateByPrimaryKeySelective(newUser);//更新用户账户余额
			
			Freeze f = new Freeze();
			f.setItemId(itemId);
			f.setPrice(200.0);
			f.setType(Freeze.BAOZHENGJIN);
			f.setUserId(userId);
			freezeMapper.insertSelective(f);//生成保证金记录
			return true;
		}
	}
	
	
	//获取最新的竞拍价格和竞拍人
	@Override
	public LatestAuctionVO latestAuction(int itemId) throws Exception {
		//首先确定商品id的合法性以及商品状态
		Item item = itemMapper.selectByPrimaryKey(itemId);
		if(item == null){
			throw new Exception("itemId非法");
		}
		if(item.getState() == Item.VERIFYING || item.getState() == Item.VERIFY_FAIL){
			throw new Exception("商品并未通过审核");
		}
		
		Auction lastAuction = auctionMapper.selectLastAuctionByItemId(itemId);
		
		LatestAuctionVO vo = new LatestAuctionVO();
		if(lastAuction == null){
//			return vo;//返回一个属性为空的对象
		}else{
			vo.setWho(userMapper.selectByPrimaryKey(lastAuction.getUserId()).getUsername());			
			vo.setPrice(lastAuction.getPrice());
		}
		return vo;
	}
	
	
	
	
	
	
	@Override
	public Map<String,Object> getMyAuctionList(Page<Auction> page) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<MyAuctionVO> voList = new ArrayList<>();//准备返回的列表集合
		//根据用户id查找出用户竞拍过的商品的总数
		int count = auctionMapper.selectItemCountByUserId(page);
		page.setTotalRecord(count);//使用内部自动计算出总页数
		
		map.put("totalPage", page.getTotalPage());
		map.put("page", page.getPage());
		
		//根据用户id查找出用户竞拍过的商品的id集合
		List<Integer> itemIdList = auctionMapper.selectItemPageByUserId(page);
		System.out.println("用户竞拍过的记录的条数：" + itemIdList.size());
		
		for(int i : itemIdList){
			MyAuctionVO vo = new MyAuctionVO();
			//获取item的详细信息
			Item item = itemMapper.selectByPrimaryKey(i);
			
			//基础信息
			vo.setItemId(i);
			vo.setBrief(item.getBrief());
			vo.setPicture(item.getPicture1());
			vo.setSeller(userMapper.selectByPrimaryKey(item.getOwner()).getUsername());
			vo.setEndDate(item.getEndDate());
			vo.setName(item.getName());
			
			Auction lastAuction = auctionMapper.selectLastAuctionByItemId(i);//获取商品最后一条竞拍记录
			vo.setCurrentPrice(lastAuction.getPrice());//当前价格
			
			Auction selectObject = new Auction();
			selectObject.setItemId(i);
			selectObject.setUserId(Integer.parseInt(page.getKeyWord()));
			Auction lastAuctionOfCurrentUser = auctionMapper.selectLastAuctionByItemIdAndUserId(selectObject);//获取当前用户对该商品最后一条竞拍记录
			vo.setMyAuctionPrice(lastAuctionOfCurrentUser.getPrice());//我的出价
			
			//竞拍状态
			if(item.getState() == Item.AUCTIONING){
				vo.setState("竞拍中");
			}else{
				//竞拍已经结束了
				if(lastAuction.getPrice().equals(lastAuctionOfCurrentUser.getPrice())){
					//竞拍结束而且最高价格就是我的价格，那么说明竞拍成功了
					vo.setState("竞拍成功");
				}else{
					vo.setState("竞拍失败");
				}
			}
			voList.add(vo);
		}
		
		map.put("data", voList);
		return map;
	}
	
	
	
	
	
	
	
	
	
	////////////////////////////////////定时器要调用的部分↓
	
	public void startAuctionOnItemStartDate() throws Exception {
		int changeCount = itemMapper.updateStateTo3OnStartDate();
		System.out.println("新增拍卖项目数量为=" + changeCount);
	};
	
	
	//测试用，把所有处于拍卖中的商品生成订单，结束拍卖状态
	@Override
	public void createOrderForTest() throws Exception {
		List<Item> list = itemMapper.selectStateEqual3();
		createOrderFromItemList(list);
	}

	//把当天结束拍卖的商品筛选出来，有人参与拍卖的则生成对应的订单并将商品状态改为成交（5），没人拍卖的则流拍（4）
	@Override
	public void createOrderFromFinishedAuction() throws Exception {
		//凌晨0：00后结算，所以筛选的是持续到昨天结束的商品   注意是包涵昨天以前的
		List<Item> list = itemMapper.selectFinishAuctionBeforeToady();
		//筛选条件包括state=3（“竞拍中”）以及结束日期是前一天或者之前，所以此方法在同一天内调用多次也不会出现意外（因为执行过后，该结束的商品的state已经不是=3了）
		createOrderFromItemList(list);
	}
	
	//把设计的itemList生成订单
	private void createOrderFromItemList(List<Item> list) throws Exception{
		if(list!=null ){
			System.out.println("结束拍卖的商品的数量为=" + list.size());
			
			for(Item item : list){
				Integer itemID = item.getId();//单条记录的id
				Auction auction = auctionMapper.selectLastAuctionByItemId(itemID);//商品获取最后一条参与拍卖的记录，作为成交的记录
				
				Item new_item = new Item();//准备进行更新操作的实体
				new_item.setId(itemID);
				
				if(auction == null){
					//没有人参与竞拍，商品状态改为流拍（但是有可能有人已经提交了保证金）
					new_item.setState(Item.AUCTION_FAIL);
					System.out.println("商品流拍");
					//流拍状态则不需要收取手续费
					Freeze shouXuFei = freezeMapper.selectShouXuFeiByItemId(itemID);
					if(shouXuFei == null){
						throw new Exception("非法");
					}
					User seller = userMapper.selectByPrimaryKey(shouXuFei.getUserId());
					double new_money = ArithUtil.add(seller.getUserMoney(), shouXuFei.getPrice());//退款后的总额
					seller = new User();
					seller.setId(seller.getId());
					seller.setUserMoney(new_money);
					
					userMapper.updateByPrimaryKeySelective(seller);//更新用户余额
					freezeMapper.deleteByPrimaryKey(shouXuFei.getId());//删除手续费
				}else{
					//有人参与拍卖，商品状态改为成交，生成订单信息
					new_item.setState(Item.AUCTION_SUCCESS);
					System.out.println("商品拍卖成功");
					
					Order new_order = new Order();
					new_order.setId(itemID);//商品id
					new_order.setCreateDate(new Date());//创建日期
					new_order.setUserId(auction.getUserId());//购买者
					new_order.setPrice(auction.getPrice());//成交价
					new_order.setState(Order.UNPAIED);//等待付款状态
					new_order.setEvaluate(false);//是否已评价
					new_order.setLastStateTime(new Date());
					System.out.println("生成的订单信息" + new_order);
					orderMapper.insertSelective(new_order);//保存生成的订单信息
				}
				
				/**
				 * 解冻其他支付了保证金而没有竞拍成功的用户的冻结金额
				 * 1、获取item_id与此相同并且type=1（表示是保证金）的所有记录
				 * 2、上面代码获取的auction对象如果不为空，则根据其用户id可确定是否有例外的不解冻项
				 */
				List<Freeze> freezeList = freezeMapper.selectBaoZhengJinByItemId(itemID);
				if(freezeList != null){
					System.out.println("保证金的数量为=" + freezeList.size());
					
					for(Freeze f:freezeList){
						User user = userMapper.selectByPrimaryKey(f.getUserId());
						Double freezePrice = f.getPrice();
						
						if(auction != null && f.getUserId() == auction.getUserId()){
							//竞拍到的用户的保证金暂时不能退回，需要等生成订单后的进一步处理
							System.out.println("有一条保证金不退回（有人竞拍）");
						}else{
							//其他用户的保证金立即退回
							User newUser = new User();
							newUser.setId(user.getId());
							newUser.setUserMoney(ArithUtil.add(user.getUserMoney(), freezePrice));
							System.out.println("退回保证金的用户" + user.getUsername());
							
							freezeMapper.deleteByPrimaryKey(f.getId());//删除保证金记录
							userMapper.updateByPrimaryKeySelective(newUser);//更新用户账户余额
						}
					}//for
				}//if
				itemMapper.updateByPrimaryKeySelective(new_item);//保存商品流拍或者成交的新状态
			}//for
		}//if
	}
	

	
	
	
	
	
	
	
	@Autowired
	private AuctionMapper auctionMapper;
	
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private FreezeMapper freezeMapper;
	
	@Autowired
	private UserMapper userMapper;
}
