package com.paipaiwang.interceptor;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//认证拦截器
public class AuthenticateInterceptor implements HandlerInterceptor{
	private static List<String> adminURIList;//后台管理中需要登录才能访问的URI集合
	
	private static List<String> userURIList;//用户需要登录才能访问的URI集合
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2) throws Exception {
		String uri = request.getRequestURI();
		logger.info("用户认证拦截器============" + uri);
		
		//后台管理系统的认证
		if(adminURIList.contains(uri)){
			//访问的资源需要登录才能访问，需要确认当前是否有管理员登录
			if(request.getSession().getAttribute("admin") == null){
				//当前没有用户登录，需要跳转到用户登录界面
				request.getRequestDispatcher("/WEB-INF/jsps/admin/login.jsp").forward(request, arg1);
				return false;
			}
		}else if(userURIList.contains(uri)){
			//用户访问的资源需要登录才能访问，需要确认当前是否有用户登录
			if(request.getSession().getAttribute("user") == null){
				arg1.setContentType("text/html;charset=UTF-8");
				PrintWriter writer = arg1.getWriter();
				writer.write("{\"result\":\"unlogin\"}");//JSON对象，标记未登录
				writer.flush();
				writer.close();
				return false;
			}
		}
		
		return true;
	}
	
	
	static{
		//初始化URI
		adminURIList = Arrays.asList(
				"/PaiPaiWang/admin/admin_index",
				"/PaiPaiWang/admin/admin_welcomePage",
				"/PaiPaiWang/admin/admin_changePWDPage",
				"/PaiPaiWang/admin/admin_changePWD",
				"/PaiPaiWang/admin/super_getAdminListPage",
				"/PaiPaiWang/admin/super_addAdminPage",
				"/PaiPaiWang/admin/super_addAdmin",
				"/PaiPaiWang/admin/super_deleteAdmin",
				"/PaiPaiWang/admin/super_editAdminPage",
				"/PaiPaiWang/admin/super_updateAdmin",
				"/PaiPaiWang/admin/super_resetPassword",
				
				"/PaiPaiWang/adv/admin_getAdvertisementListPage",
				"/PaiPaiWang/adv/admin_editAdvPage",
				"/PaiPaiWang/adv/admin_updateAdv",
				
				"/PaiPaiWang/item/admin_getUnverifyItemPage",
				"/PaiPaiWang/item/admin_verifyItemDetail",
				"/PaiPaiWang/item/admin_verifyItem",
				"/PaiPaiWang/item/admin_getVerifiedItemPage",
				"/PaiPaiWang/item/admin_itemDetail",

				"/PaiPaiWang/order/admin_getOrderListPage",
				"/PaiPaiWang/order/admin_orderDetailPage",
				"/PaiPaiWang/order/admin_getInterveneListPage",

				"/PaiPaiWang/user/admin_getUserListPage",
				"/PaiPaiWang/user/admin_freezeUser",
				"/PaiPaiWang/user/admin_userDetail",
				"/PaiPaiWang/user/admin_addMoney",
				"/PaiPaiWang/user/admin_subMoney"
				);
		
		
		userURIList = Arrays.asList(
				"/PaiPaiWang/user/editUser",
				"/PaiPaiWang/user/changePwd",
				
				"/PaiPaiWang/auction/payAuctionFreeze",
				"/PaiPaiWang/auction/auction",
				"/PaiPaiWang/auction/myAuction",
				
				"/PaiPaiWang/item/publish",
				"/PaiPaiWang/item/checkMoneyForFreeze",
				"/PaiPaiWang/item/publishedPage",
				"/PaiPaiWang/item/changeItemCollect",
				"/PaiPaiWang/item/collectionPage",

				"/PaiPaiWang/order/buyOrderPage",
				
						
				""
				);
	}
	
	

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	private Logger logger = LogManager.getLogger(getClass());

}
