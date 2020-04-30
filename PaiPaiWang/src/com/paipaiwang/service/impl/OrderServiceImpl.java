package com.paipaiwang.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipaiwang.admin.vo.InterveneListVO;
import com.paipaiwang.admin.vo.InterveneVO;
import com.paipaiwang.admin.vo.OrderDetailVO;
import com.paipaiwang.admin.vo.OrderListVO;
import com.paipaiwang.dao.FreezeMapper;
import com.paipaiwang.dao.InterveneMapper;
import com.paipaiwang.dao.ItemMapper;
import com.paipaiwang.dao.OrderMapper;
import com.paipaiwang.dao.UserMapper;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.po.Freeze;
import com.paipaiwang.po.Intervene;
import com.paipaiwang.po.Item;
import com.paipaiwang.po.Order;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.service.OrderService;
import com.paipaiwang.user.vo.AddressVO;
import com.paipaiwang.user.vo.MyOrderVO;
import com.paipaiwang.user.vo.PayOrderVO;
import com.paipaiwang.utils.ArithUtil;

@Service
public class OrderServiceImpl implements OrderService{

	public Page<Order> findOrders(Page<Order> page) throws Exception{
		page.setList(orderMapper.selectPageList(page));
		page.setTotalRecord(orderMapper.selectPageCount(page));
		
		List<OrderListVO> voList = new LinkedList<OrderListVO>();
		List<Order> list = page.getList();
		
		if(list!=null){
			for(Order o : list){
				OrderListVO vo = new OrderListVO();
				if(page.getKeyWord() != null && !page.getKeyWord().equals("")){
					vo.setId((o.getId()+"").replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
					vo.setName(o.getRemark().replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
				}else{
					vo.setId(o.getId()+"");
					vo.setName(o.getRemark());
				}
				vo.setPrice(o.getPrice());
				vo.setCreateDate(o.getCreateDate());
				vo.setSeller(userMapper.selectByPrimaryKey(o.getUserId()).getUsername());
				vo.setBuyer(userMapper.selectByPrimaryKey(itemMapper.selectByPrimaryKey(o.getId()).getOwner()).getUsername());
				switch(o.getState()){
				case Order.UNPAIED:			vo.setState("等待买家付款");			break;
				case Order.PAIED:			vo.setState("等待卖家发货");			break;
				case Order.SENT:			vo.setState("卖家已发货");				break;
				case Order.SUCCESS:			vo.setState("交易成功");				break;
				case Order.ASK_RETURN:		vo.setState("买家申请退货");			break;
				case Order.RETURNED:		vo.setState("已退货");				break;
				case Order.BUY_CANCEL:		vo.setState("买家取消订单");			break;
				case Order.SELL_CANCEL:		vo.setState("卖家取消订单");			break;
				}
				voList.add(vo);
			}//for
		}//if
		page.getPageMap().put("rows",voList);//rows的实体改成vo对象
		
		return page;
	}

	@Override
	public Page<Intervene> findIntervenes(Page<Intervene> page)
			throws Exception {
		page.setTotalRecord(interveneMapper.selectPageCount(page));
		
		List<Intervene> list = interveneMapper.selectPageList(page);
		List<InterveneListVO> voList = new ArrayList<>();
		
		if(list != null){
			for(Intervene i: list){
				InterveneListVO vo = new InterveneListVO();
				
				if(page.getKeyWord() != null && !page.getKeyWord().equals("")){
					vo.setItemId((i.getOrderId() + "").replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
				}else{
					vo.setItemId(i.getOrderId() + "");
				}
				vo.setRequestType( i.getType()==Intervene.BUYER_REQUEST ? "买家诉求" : "卖家诉求" );
				
				Order order = orderMapper.selectByPrimaryKey(i.getOrderId());
				User buyer = userMapper.selectByPrimaryKey(order.getUserId());
				User seller = userMapper.selectByPrimaryKey(itemMapper.selectByPrimaryKey(i.getOrderId()).getOwner());
				vo.setSeller(seller.getUsername());
				vo.setBuyer(buyer.getUsername());
				
				vo.setPrice(order.getPrice());
				vo.setFinishTime(new SimpleDateFormat("yyyy-MM-dd").format(order.getCreateDate()));
				vo.setRequestTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(i.getCreateTime()));
				vo.setInterveneId(i.getId());
				
				vo.setHandled(i.getState() == Intervene.OK);
				voList.add(vo);
			}
		}
		System.out.println(voList);
		page.getPageMap().put("rows",voList);//rows的实体改成vo对象
		return page;
	}
	

	@Override
	public InterveneVO findInterveneDetail(int id) throws Exception {
		InterveneVO vo = new InterveneVO();
		
		Intervene intervene = interveneMapper.selectByPrimaryKey(id);
		Integer orderId = intervene.getOrderId();
		
		OrderDetailVO orderDetailVO = fingOrderDetail(orderId);
		vo.setOrderDetailVO(orderDetailVO);
		vo.setForWhat(intervene.getForWhat());
		vo.setForWhy(intervene.getForWhy());
		vo.setInterveneId(intervene.getId());
		
		List<Freeze> freezeList = freezeMapper.selectBaoZhengJinByItemId(orderId);
		if(freezeList.size() > 1){
			throw new Exception();
		}
		Freeze baozhengjin = freezeList.size()==1?freezeList.get(0):null;
		Freeze goumaijin = freezeMapper.selectGouMaiJinByItemId(orderId);
		Freeze shouxufei = freezeMapper.selectShouXuFeiByItemId(orderId);
		
		Double allMoney = 0.0;
		if(baozhengjin != null){
			allMoney = ArithUtil.add(allMoney, baozhengjin.getPrice());
		}
		if(goumaijin != null){
			allMoney = ArithUtil.add(allMoney, goumaijin.getPrice());
		}
		if(shouxufei != null){
			allMoney = ArithUtil.add(allMoney, shouxufei.getPrice());
		}
		vo.setFreezeMoney(allMoney);
		return vo;
	}
	
	@Override
	public void handleIntervene(Integer id, Boolean agree) throws Exception {
		Intervene intervene = interveneMapper.selectByPrimaryKey(id);
		if(intervene == null){
			throw new Exception();
		}
		
		Intervene new_intervene = new Intervene();
		new_intervene.setId(id);
		
		if(agree){
			/**
			 * 同意申请
			 * 1、删除所有的保证金
			 * 2、把订单状态改为“平台介入”
			 * 3、把本申请改为“已处理”，同时如果另一方也存在申请记录，则修改为“已处理”
			 */
			Integer orderId = intervene.getOrderId();
			int deleteCount = freezeMapper.deleteAllFreezeMoneyByOrderId(orderId);
			System.out.println("删除的冻结金额记录=" + deleteCount);
			
			Order new_order = new Order();
			new_order.setId(orderId);
			new_order.setState(Order.INTERVENED);
			orderMapper.updateByPrimaryKeySelective(new_order);
			
			interveneMapper.handleInterveneByOrderId(orderId);
		}else{
			//否决申请
			new_intervene.setState(Intervene.OK);//已处理
			interveneMapper.updateByPrimaryKeySelective(new_intervene);
		}
	}
	
	@Override
	public OrderDetailVO fingOrderDetail(int id) throws Exception {
		
		Order order = orderMapper.selectByPrimaryKey(id);
		if(order == null){
			throw new AdminUnknowException("不存在的订单号",null);
		}
		
		OrderDetailVO vo = new OrderDetailVO(order);
		vo.setSeller(userMapper.selectByPrimaryKey(order.getUserId()).getUsername());
		vo.setBuyer(userMapper.selectByPrimaryKey(itemMapper.selectByPrimaryKey(order.getId()).getOwner()).getUsername());
		switch(order.getState()){
		case Order.UNPAIED:			vo.setState("等待买家付款");			break;
		case Order.PAIED:			vo.setState("等待卖家发货");			break;
		case Order.SENT:			vo.setState("卖家已发货");				break;
		case Order.SUCCESS:			vo.setState("交易成功");				break;
		case Order.ASK_RETURN:		vo.setState("买家申请退货");			break;
		case Order.RETURNED:		vo.setState("已退货");				break;
		case Order.BUY_CANCEL:		vo.setState("买家取消订单");			break;
		case Order.SELL_CANCEL:		vo.setState("卖家取消订单");			break;
		}
		
		return vo;
	}
	

	//获取当前用户的购买订单分页
	@Override
	public Map<String, Object> buyOrderPage(int page, int userId)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MyOrderVO> voList = new ArrayList<>();
		
		Page<Order> queryPage = new Page<Order>();
		queryPage.setPage(page);
		queryPage.setRows(10);
		queryPage.setKeyWord(userId + "");//用户id存在keyword字段
		
		int count = orderMapper.selectBuyOrderCountByUserId(queryPage);
		queryPage.setTotalRecord(count);
		map.put("totalPage", queryPage.getTotalPage());
		map.put("page", page);
		
		//先获取当前用户的购买订单的指定页
		List<Order> OrderList = orderMapper.selectBuyOrderPageByUserId(queryPage);
		if(OrderList!=null){
			for(Order o:OrderList){
				MyOrderVO vo = new MyOrderVO();
				vo.setId(o.getId());
				vo.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(o.getCreateDate()));
				
				Item item = itemMapper.selectByPrimaryKey(o.getId());//此订单对应的商品
				User seller = userMapper.selectByPrimaryKey(item.getOwner());
				vo.setOpposite(seller.getUsername() + "(" + seller.getMobiphone() + ")");
				vo.setPicture(item.getPicture1());
				vo.setName(item.getName());
				vo.setBrief(item.getBrief());
				vo.setPrice(o.getPrice());
				vo.setNumber(item.getNumber());
				vo.setState(o.getState());
				
				vo.setEvaluate(o.getEvaluate());//是否已评价
				
				//送货信息部分    当处于“已发货”状态，才需要追踪物流信息
				if(o.getState() == Order.SENT){
					vo.setSendGoodsMessage("快递信息：" + o.getExpressCompany() +" 单号：" + o.getExpressId());
				}
				//判断是否已经申请过平台介入部分
				Intervene queryIntervene = new Intervene();
				queryIntervene.setId(o.getId());
				queryIntervene.setType(Intervene.BUYER_REQUEST);
				
				Intervene intervene = interveneMapper.selectByOrderIdAndType(queryIntervene);
				vo.setIntervene(intervene != null);
				if(intervene!=null){
					vo.setHandledIntervene(intervene.getState());
				}
				voList.add(vo);
			}
		}
		map.put("data", voList);
		return map;
	}
	
	//获取当前用户的出售订单分页
	@Override
	public Map<String, Object> sellOrderPage(int page, int userId)	throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MyOrderVO> voList = new ArrayList<>();
		
		Page<Order> queryPage = new Page<Order>();
		queryPage.setPage(page);
		queryPage.setRows(10);
		queryPage.setKeyWord(userId + "");//用户id存在keyword字段
		
		int count = orderMapper.selectSellOrderCountByUserId(queryPage);
		queryPage.setTotalRecord(count);
		map.put("totalPage", queryPage.getTotalPage());
		map.put("page", page);
		
		List<Order> OrderList = orderMapper.selectSellOrderPageByUserId(queryPage);
		if(OrderList!=null){
			for(Order o:OrderList){
				MyOrderVO vo = new MyOrderVO();
				vo.setId(o.getId());
				vo.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").format(o.getCreateDate()));
				
				Item item = itemMapper.selectByPrimaryKey(o.getId());//此订单对应的商品
				User buyer = userMapper.selectByPrimaryKey(o.getUserId());//买家
				vo.setOpposite(buyer.getUsername() + "(" + buyer.getMobiphone() + ")");
				vo.setPicture(item.getPicture1());
				vo.setName(item.getName());
				vo.setBrief(item.getBrief());
				vo.setPrice(o.getPrice());
				vo.setNumber(item.getNumber());
				vo.setState(o.getState());
				
				vo.setEvaluate(o.getEvaluate());//是否已评价
				
				//送货信息部分    当处于“已发货”状态，才需要追踪物流信息
				if(o.getState() == Order.SENT){
					vo.setSendGoodsMessage("快递信息：" + o.getExpressCompany() +" 单号：" + o.getExpressId());
				}
				//判断是否已经申请过平台介入部分（卖家一方）
				Intervene queryIntervene = new Intervene();
				queryIntervene.setId(o.getId());
				queryIntervene.setType(Intervene.SELLER_REQUEST);
				
				Intervene intervene = interveneMapper.selectByOrderIdAndType(queryIntervene);
				vo.setIntervene(intervene != null);
				if(intervene!=null){
					vo.setHandledIntervene(intervene.getState());
				}
				voList.add(vo);
			}
		}
		map.put("data", voList);
		return map;
	}
	
	/**
	 * 用户取消购买订单，
	 * 1、订单修改为指定状态
	 * 2、退回用户的手续费
	 * 3、用户竞拍支付的保证金赔付给卖家
	 */
	@Override
	public synchronized void cancelBuyOrder(Integer orderId, Integer userId)
			throws Exception {
		
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null || order.getUserId() != userId){
			//当前用户要取消的并不是他的购买订单
			throw new Exception();
		}
		if(order.getState() != Order.UNPAIED){
			//当前订单并非处于等待付款状态
			throw new Exception();
		}
		
		Order new_order = new Order();
		new_order.setId(orderId);
		new_order.setState(Order.BUY_CANCEL);//买家取消订单
		orderMapper.updateByPrimaryKeySelective(new_order);//更新订单状态
		
		Freeze baozhengjin = freezeMapper.selectBaoZhengJinByUseridAndItemid(userId, orderId);//保证金记录
		Freeze shouxufei = freezeMapper.selectShouXuFeiByItemId(orderId);//手续费
		
		double moneyBelongToSeller = ArithUtil.add(baozhengjin.getPrice(), shouxufei.getPrice());//手续费和保证金都归卖家所有

		Item item = itemMapper.selectByPrimaryKey(orderId);
		User seller = userMapper.selectByPrimaryKey(item.getOwner());
		User new_user = new User();
		new_user.setId(seller.getId());
		new_user.setUserMoney(ArithUtil.add(seller.getUserMoney(),moneyBelongToSeller));
		userMapper.updateByPrimaryKeySelective(new_user);//更新用户的账户信息
		
		freezeMapper.deleteByPrimaryKey(baozhengjin.getId());//删除对应的冻结金额记录
		freezeMapper.deleteByPrimaryKey(shouxufei.getId());
	}
	
	/**
	 * 卖家取消出卖订单
	 * 1、订单修改为指定状态
	 * 2、返回用户的保证金和购买金额
	 * 3、卖家支付的手续费将赔付给买家
	 */
	@Override
	public synchronized void cancelSellOrder(Integer orderId, Integer userId) throws Exception {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			//订单不存在
			throw new Exception();
		}
		Item item = itemMapper.selectByPrimaryKey(orderId);
		if(item.getOwner() != userId){
			//当前用户并不是卖家
			throw new Exception();
		}
		if(order.getState() != Order.PAIED){
			//当前订单并非处于已付款状态
			throw new Exception();
		}
		
		Order new_order = new Order();
		new_order.setId(orderId);
		new_order.setState(Order.SELL_CANCEL);//买家取消订单
		orderMapper.updateByPrimaryKeySelective(new_order);//更新订单状态
		
		Freeze shouxufei = freezeMapper.selectShouXuFeiByItemId(orderId);//手续费
		Freeze baozhengjin = freezeMapper.selectBaoZhengJinByUseridAndItemid(order.getUserId(), orderId);//保证金记录
		Freeze goumaijin = freezeMapper.selectGouMaiJinByItemId(orderId);
		
		double moneyBelongToBuyer = ArithUtil.add(baozhengjin.getPrice(), shouxufei.getPrice());
		moneyBelongToBuyer = ArithUtil.add(moneyBelongToBuyer, goumaijin.getPrice());
		System.out.println(baozhengjin.getPrice());
		System.out.println(shouxufei.getPrice());
		System.out.println(goumaijin.getPrice());
		System.out.println("赔偿买家金额="+moneyBelongToBuyer);

		User user = userMapper.selectByPrimaryKey(order.getUserId());
		User new_user = new User();
		new_user.setId(order.getUserId());//要增加余额的是买家而不是卖家
		new_user.setUserMoney(ArithUtil.add(user.getUserMoney(),moneyBelongToBuyer));
		userMapper.updateByPrimaryKeySelective(new_user);//提交更新

		freezeMapper.deleteByPrimaryKey(baozhengjin.getId());//删除对应的冻结金额记录
		freezeMapper.deleteByPrimaryKey(shouxufei.getId());
		freezeMapper.deleteByPrimaryKey(goumaijin.getId());
	}
	
	//申请介入
	@Override
	public void buyerRequestIntervene(Intervene intervene) throws Exception {
		/**
		 * 首先需要判断订单号存在，原先并没有该申请存在（暂时先不做）
		 */
		Order order = orderMapper.selectByPrimaryKey(intervene.getOrderId());
		if(order == null){
			throw new Exception();
		}
		
		Intervene queryIntervene = new Intervene();
		queryIntervene.setId(intervene.getOrderId());
		queryIntervene.setType(Intervene.BUYER_REQUEST);
		
		Intervene exited = interveneMapper.selectByOrderIdAndType(queryIntervene);
		if(exited != null){
			throw new Exception();
		}
		
		intervene.setType(Intervene.BUYER_REQUEST);
		intervene.setState(Intervene.NO);
		intervene.setCreateTime(new Date());
		interveneMapper.insertSelective(intervene);
	}
	
	@Override
	public void sellerRequestIntervene(Intervene intervene) throws Exception {
		/**
		 * 首先需要判断订单号存在，原先并没有该申请存在（暂时先不做）
		 */
		Order order = orderMapper.selectByPrimaryKey(intervene.getOrderId());
		if(order == null){
			throw new Exception();
		}
		
		Intervene queryIntervene = new Intervene();
		queryIntervene.setId(intervene.getOrderId());
		queryIntervene.setType(Intervene.SELLER_REQUEST);
		
		Intervene exited = interveneMapper.selectByOrderIdAndType(queryIntervene);
		if(exited != null){
			throw new Exception();
		}
		
		intervene.setType(Intervene.SELLER_REQUEST);
		intervene.setState(Intervene.NO);
		intervene.setCreateTime(new Date());
		interveneMapper.insertSelective(intervene);
	}
	
	@Override
	public synchronized Boolean payForOrder(PayOrderVO vo, Integer userId)	throws Exception {
		Order order = orderMapper.selectByPrimaryKey(vo.getOrderId());
		//处于待付款状态
		if(order.getState() != Order.UNPAIED){
			throw new Exception();
		}
		if(order.getUserId()!= userId){
			throw new Exception();
		}
		
		//判断用户余额是否大于订单价格
		User user = userMapper.selectByPrimaryKey(userId);
		Double userMoney = user.getUserMoney();
		if(userMoney < order.getPrice()){
			return false;
		}
		
		//确定余额足够的情况下  修改订单的状态以及保存收货地址信息，扣除用户余额，生成冻结金额记录
		Order new_order = new Order();
		new_order.setId(vo.getOrderId());
		new_order.setState(Order.PAIED);//已付款
		new_order.setLastStateTime(new Date());
		
		new_order.setSendName(vo.getName());
		new_order.setSendPhone(vo.getPhone());
		new_order.setSendAddress(vo.getAddress());
		new_order.setSendPostcode(vo.getPostcode());
		new_order.setSendOthers(vo.getOther());
		
		orderMapper.updateByPrimaryKeySelective(new_order);
		
		double userMoneyLeft = ArithUtil.sub(userMoney, order.getPrice());
		User new_user = new User();
		new_user.setId(user.getId());
		new_user.setUserMoney(userMoneyLeft);//更新余额
		userMapper.updateByPrimaryKeySelective(new_user);
		
		Freeze f = new Freeze();
		f.setItemId(vo.getOrderId());
		f.setPrice(order.getPrice());
		f.setType(Freeze.GOUMAIJIN);
		f.setUserId(userId);
		freezeMapper.insertSelective(f);
		
		return true;//返回true说明支付陈功
	}
	
	
	
	@Override
	public AddressVO getAddressMessage(Integer orderId, Integer userId)
			throws Exception {
		
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			throw new Exception();
		}
		
		Item item = itemMapper.selectByPrimaryKey(orderId);
		if(item.getOwner() != userId){
			throw new Exception();
		}
		if(order.getState() != order.PAIED){
			throw new Exception();
		}
		
		AddressVO vo = new AddressVO();
		vo.setUsername(order.getSendName());
		vo.setAddress(order.getSendAddress());
		vo.setPhone(order.getSendPhone());
		vo.setPostcode(order.getSendPostcode());
		vo.setOther(order.getSendOthers());
		
		return vo;
	}
	
	
	@Override
	public void sendGoods(Integer orderId, String express_company,String express_id, Integer userId) throws Exception {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			throw new Exception();
		}
		Item item = itemMapper.selectByPrimaryKey(orderId);
		if(item.getOwner() != userId){
			throw new Exception();
		}
		if(order.getState() != order.PAIED){
			throw new Exception();
		}
		
		//保存快递信息，更改状态为“已发货”
		Order new_order = new Order();
		new_order.setId(orderId);
		new_order.setExpressCompany(express_company);
		new_order.setExpressId(express_id);
		new_order.setState(Order.SENT);
		new_order.setLastStateTime(new Date());//记录上个流程的时间
		
		orderMapper.updateByPrimaryKeySelective(new_order);
	}
	
	
	@Override
	public void getGoodsConfirm(Integer orderId, Integer userId)throws Exception {
		
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			throw new Exception();
		}
		if(order.getState() != order.SENT){
			throw new Exception();
		}
		if(order.getUserId() != userId){
			throw new Exception();//确认买家身份
		}
		
		//解冻保证金，收缴手续费，把冻结的购买金转入卖家账户
		Freeze baozhengjin = freezeMapper.selectBaoZhengJinByUseridAndItemid(order.getUserId(), orderId);
		Freeze goumaijin = freezeMapper.selectGouMaiJinByItemId(orderId);
		Freeze shouxufei = freezeMapper.selectShouXuFeiByItemId(orderId);
		if(baozhengjin==null || goumaijin==null || shouxufei==null){
			throw new Exception();//冻结金额错误
		}
		
		User buyer = userMapper.selectByPrimaryKey(order.getUserId());
		User seller = userMapper.selectByPrimaryKey(itemMapper.selectByPrimaryKey(orderId).getOwner());
		
		freezeMapper.deleteByPrimaryKey(shouxufei.getId());//系统收取手续费
		
		double userMoney = ArithUtil.add(seller.getUserMoney(), goumaijin.getPrice());
		User new_seller = new User();
		new_seller.setId(seller.getId());
		new_seller.setUserMoney(userMoney);
		userMapper.updateByPrimaryKeySelective(new_seller);//卖家收取购买金
		freezeMapper.deleteByPrimaryKey(goumaijin.getId());
		
		userMoney = ArithUtil.add(buyer.getUserMoney(), baozhengjin.getPrice());
		User new_buyer = new User();
		new_buyer.setId(buyer.getId());
		new_buyer.setUserMoney(userMoney);
		userMapper.updateByPrimaryKeySelective(new_buyer);//退回用户保证金
		freezeMapper.deleteByPrimaryKey(baozhengjin.getId());
		
		//把状态改为“交易成功”，并保存finishTime和lastStateTime
		Order new_order = new Order();
		new_order.setId(orderId);
		new_order.setState(Order.SUCCESS);
		new_order.setLastStateTime(new Date());//记录上个流程的时间
		new_order.setFinishTime(new Date());
		
		orderMapper.updateByPrimaryKeySelective(new_order);
	}
	
	@Override
	public void requestReturn(Integer orderId, String return_reason,Integer userId) throws Exception {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			throw new Exception();
		}
		if(order.getState() != order.SUCCESS){
			throw new Exception();
		}
		if(order.getUserId() != userId){
			throw new Exception();//确认买家身份
		}
		
		//更改状态为“申请退货”
		Order new_order = new Order();
		new_order.setId(orderId);
		new_order.setState(Order.ASK_RETURN);//申请退货
		new_order.setReturnReason(return_reason);
		new_order.setLastStateTime(new Date());//记录上个流程的时间
		
		orderMapper.updateByPrimaryKeySelective(new_order);
	}
	
	@Override
	public String returnReason(Integer orderId, Integer userId)	throws Exception {
		//确认当前用户是订单的卖家，并且当前订单处于“申请退货中”
		Order order = orderMapper.selectByPrimaryKey(orderId);
		Item item = itemMapper.selectByPrimaryKey(orderId);
		if(order == null){
			throw new Exception();
		}
		if(item.getOwner() != userId){
			throw new Exception("当前用户不是卖家");
		}
		if(order.getState() != Order.ASK_RETURN){
			throw new Exception("并非处于申请退货状态");
		}
		return order.getReturnReason();
	}
	
	@Override
	public boolean handelReturnRequest(Integer orderId, Integer userId,Boolean agree) throws Exception {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			throw new Exception();
		}
		if(order.getState() != order.ASK_RETURN){
			throw new Exception();
		}
		Item item = itemMapper.selectByPrimaryKey(orderId);
		if(item.getOwner() != userId){//当前用户不是该商品的所有者
			throw new Exception();
		}
		
		Order new_order = new Order();
		new_order.setId(orderId);
		
		//拒绝退货，则订单状态改回：“交易成功”
		if(!agree){
			new_order.setState(Order.SUCCESS);
			new_order.setReturnReason("");//清空退货原因
			new_order.setLastStateTime(new Date());//记录上个流程的时间
			orderMapper.updateByPrimaryKeySelective(new_order);
			return true;
		}
		
		//同意退货，先检查用户余额是否足够退回货款，
		//如果足够，则订单状态改为“已退货”，扣除卖家货款，买家余额增加  返回true
		//如果不够 返回false
		if(agree){
			User seller = userMapper.selectByPrimaryKey(userId);
			if(order.getPrice() > seller.getUserMoney()){
				return false;//余额不足退换给买家，退货操作失败
			}
			
			new_order.setState(Order.RETURNED);
			new_order.setLastStateTime(new Date());//记录上个流程的时间
			orderMapper.updateByPrimaryKeySelective(new_order);
			
			double userMoney = ArithUtil.sub(seller.getUserMoney(), order.getPrice());
			User new_user = new User();
			new_user.setId(userId);
			new_user.setUserMoney(userMoney);
			userMapper.updateByPrimaryKeySelective(new_user);
			
			User buyer = userMapper.selectByPrimaryKey(order.getUserId());
			userMoney = ArithUtil.add(buyer.getUserMoney(), order.getPrice());
			new_user = new User();
			new_user.setId(buyer.getId());
			new_user.setUserMoney(userMoney);
			userMapper.updateByPrimaryKeySelective(new_user);
			return true;
		}
		throw new Exception();//不应该执行到这里来的，上面判断已经包括所有情况了
	}
	
	
	@Override
	public void evaluateItem(Integer orderId, Integer userId, String evaluation)
			throws Exception {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			throw new Exception();
		}
		if(order.getState() != Order.SUCCESS){//订单必须处于“交易陈功”状态
			throw new Exception();
		}
		if(order.getUserId() != userId){
			throw new Exception();
		}
		if(order.getEvaluate()){//已经有过评价了
			throw new Exception();
		}
		
		Order new_order = new Order();
		new_order.setId(orderId);
		new_order.setEvaluate(true);
		new_order.setEvaluation(evaluation);
		orderMapper.updateByPrimaryKeySelective(new_order);
	}
	
	@Override
	public String findEvaluationByOrderId(Integer orderId, Integer userId)
			throws Exception {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if(order == null){
			throw new Exception();
		}
		if(order.getState() != Order.SUCCESS){//订单必须处于“交易陈功”状态
			throw new Exception();
		}
		Item item = itemMapper.selectByPrimaryKey(orderId);
		if(item.getOwner() != userId){//当前用户不是该商品的所有者
			throw new Exception();
		}
		if(!order.getEvaluate()){//还没有评价了
			throw new Exception();
		}
		return order.getEvaluation();
	}
	
	
	
	
	@Override
	public void checkPayIn24Hours() throws Exception {
		
	}
	@Override
	public void checkReturnConfirmIn72Hours() throws Exception {
		
	}
	@Override
	public void checkSendIn48Hours() throws Exception {
		
	}
	
	
	
	@Autowired
	private FreezeMapper freezeMapper;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private InterveneMapper interveneMapper;
	

}
