package com.paipaiwang.service;

import java.util.Map;

import com.paipaiwang.admin.vo.InterveneVO;
import com.paipaiwang.admin.vo.OrderDetailVO;
import com.paipaiwang.po.Intervene;
import com.paipaiwang.po.Order;
import com.paipaiwang.po.Page;
import com.paipaiwang.user.vo.AddressVO;
import com.paipaiwang.user.vo.PayOrderVO;

public interface OrderService {
	
	public Page<Order> findOrders(Page<Order> page) throws Exception;//管理员获取订单列表
	
	public OrderDetailVO fingOrderDetail(int id)throws Exception;//管理员获取订单详情
	
	public Page<Intervene> findIntervenes(Page<Intervene> page)throws Exception;//管理员获取纠纷处理请求列表
	
	public InterveneVO findInterveneDetail(int id)throws Exception;//管理员获取纠纷处理申请详情
	
	public void handleIntervene(Integer id,Boolean agree)throws Exception;//管理员处理纠纷申请
	
	
	//获取当前用户的购买订单分页
	public Map<String,Object> buyOrderPage(int page,int userId)throws Exception;
	
	//获取当前用户的出售订单分页
	public Map<String,Object> sellOrderPage(int page,int userId)throws Exception;
	
	//用户取消购买订单
	public void cancelBuyOrder(Integer orderId,Integer userId)throws Exception;
	
	//卖家取消出卖订单
	public void cancelSellOrder(Integer orderId,Integer userId)throws Exception;
	
	//买家申请平台介入
	public void buyerRequestIntervene(Intervene intervene)throws Exception;
	
	//卖申请平台介入
	public void sellerRequestIntervene(Intervene intervene)throws Exception;
	
	//用户支付订单  成功返回true，余额不够则返回false
	public Boolean payForOrder(PayOrderVO vo,Integer userId)throws Exception;
	
	//获取订单上填写的发货地址
	public AddressVO getAddressMessage(Integer orderId,Integer userId)throws Exception;
	
	//卖家发货
	public void sendGoods(Integer orderId,String express_company,String express_id,Integer userId)throws Exception;
	
	//确认收货
	public void getGoodsConfirm(Integer orderId,Integer userId)throws Exception;
	
	//买家申请退货
	public void requestReturn(Integer orderId,String return_reason,Integer userId)throws Exception;
	
	//卖家查看申请退货的理由
	public String returnReason(Integer orderId,Integer userId)throws Exception;
	
	//卖家处理退货请求
	public boolean handelReturnRequest(Integer orderId,Integer userId,Boolean agree)throws Exception;
	
	//买家评价订单
	public void evaluateItem(Integer orderId,Integer userId,String evaluation )throws Exception;
	
	//获取订单对应的评价信息
	public String findEvaluationByOrderId(Integer orderId,Integer userId)throws Exception;
	
	
	
	
	
	
	//定时任务↓↓↓↓↓↓↓↓
	public void checkPayIn24Hours()throws Exception;//24小时 内付款
	
	public void checkSendIn48Hours()throws Exception;//48小时内发货
	
	public void checkReturnConfirmIn72Hours()throws Exception;//72小时内处理退货请求
	
	
	
	
}
