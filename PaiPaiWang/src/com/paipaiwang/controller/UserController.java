package com.paipaiwang.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paipaiwang.admin.vo.UserDetailVO;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.service.UserService;
import com.paipaiwang.user.vo.AddressVO;
import com.paipaiwang.user.vo.ChangePwdVO;
import com.paipaiwang.user.vo.EditUserVO;
import com.paipaiwang.user.vo.RegistOneVO;
import com.paipaiwang.user.vo.RegistTwoVO;
import com.paipaiwang.utils.MD5Util;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//获取手机验证码
	@ResponseBody
	@RequestMapping("/getRegistVerifyCode")
	public Object getRegistVerifyCode(String phone,HttpServletRequest request) throws Exception {
		//空值校验
		if(phone == null){
			return null;
		}
		Thread.sleep(1000);
		User user = userService.findUserByMobile(phone);
		if(user != null){
			return "{\"result\":\"fail\"}";//该手机号已经被注册过了
		}else{
			request.getSession().setAttribute("registPhone", phone);//为第二步注册做准备
			request.getSession().setAttribute("verifyCode", "8888");//模拟发送了验证码，为8888
			return "{\"result\":\"ok\"}";//该手机号可用
		}
	}
	
	//获取手机验证码
	@ResponseBody
	@RequestMapping("/getAllFreezeMoney")
	public Object getAllFreezeMoney(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)request.getSession().getAttribute("user");
		try {
			map.put("result", "ok");
			Double money = userService.getAllFreezeMoneyByUserId(user.getId());
			map.put("data", money);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//用户余额充值
	@ResponseBody
	@RequestMapping("/recharge")
	public String recharge(Double money,HttpServletRequest request)throws Exception {
		//空值校验
		if(money == null){
			return null;
		}

		User user = (User)request.getSession().getAttribute("user");
		try {
			userService.recharge(user.getId(), money);
			user = userService.getUserById(user.getId());
			request.getSession().setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
		return "{\"result\":\"ok\"}";//充值成功
	}
	
	//帐号注册第一步提交验证
	@ResponseBody
	@RequestMapping("/registOne")
	public Object regist1(RegistOneVO vo,HttpServletRequest request) throws Exception {
		//空值校验
		if(vo.getName() == null || vo.getPhone() == null || vo.getPwd() == null || vo.getPwd2() == null || vo.getVerifyCode() == null){
			return null;
		}
		
		//首先判断手机号码和验证码是否匹配
		String phone = (String) request.getSession().getAttribute("registPhone");
		String verifyCode =  (String) request.getSession().getAttribute("verifyCode");
		request.getSession().removeAttribute("registPhone");
		request.getSession().removeAttribute("verifyCode");
		//两者都必须相同
		if(phone==null || verifyCode == null || !vo.getPhone().equals(phone) || !vo.getVerifyCode().equals(verifyCode)){
			return "{\"result\":\"verifyCode\"}";
		}
		//判断密码1的格式
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,18}$");
		if(!pattern.matcher(vo.getPwd()).matches()){
			return "{\"result\":\"pwd\"}";
		}
		//判断密码2与密码1是否相同
		if(!vo.getPwd().equals(vo.getPwd2())){
			return "{\"result\":\"pwd2\"}";
		}
		//用户名长度
		if(vo.getName().length() > 8){
			return "{\"result\":\"name\"}";
		}

		Thread.sleep(1000);
		request.getSession().setAttribute("registOne", vo);
		return "{\"result\":\"ok\"}";
	}
	
	//帐号注册第一步提交验证
	@ResponseBody
	@RequestMapping("/registTwo")
	public Object registTwo(RegistTwoVO vo,HttpServletRequest request) throws Exception {
		
		//空值校验
		if(vo.getRealname() == null || vo.getGender() == null || vo.getAddress() == null || vo.getEmail() == null 
				|| vo.getIdcard() == null || vo.getPostcode() == null){
			return null;
		}
		
		RegistOneVO vo1 = (RegistOneVO) request.getSession().getAttribute("registOne");
		request.getSession().removeAttribute("registOne");
		
		if(vo1 == null){
			return "{\"result\":\"registOne\"}";
		}
		
		User user = new User();
		user.setAddress(vo.getAddress());
		user.setEmail(vo.getEmail());
		user.setFreeze(false);
		user.setGender(vo.getGender());
		user.setIdcard(vo.getIdcard());
		user.setMobiphone(vo1.getPhone());
		user.setPassword(MD5Util.decodePasswd(vo1.getPwd()));
		user.setPostcode(vo.getPostcode());
		user.setRealname(vo.getRealname());
		user.setUserMoney(0.00);
		user.setUsername(vo1.getName());
		try {
			userService.addUser(user);//业务内需要补全判断信息有效性的代码以及判断手机号码的唯一性
			
			//然后自动登录
			User sessionUser = userService.findUserByMobile(user.getMobiphone());
			request.getSession().setAttribute("user", sessionUser);
			return "{\"result\":\"ok\"}";//接收到成功信息后，前端会跳转到首页，自动登陆后的状态
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//注销登录
	@ResponseBody
	@RequestMapping("/logout")
	public Object logout(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "{\"result\":\"ok\"}";
	}
	
	
	//登录
	@ResponseBody
	@RequestMapping("/login")
	public Object login(String phone,String pwd,HttpServletRequest request){
		//空值校验
		if(phone == null || pwd == null ){
			return null;
		}
		
		User user;
		try {
			user = userService.findUserByMobile(phone);
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
		
		if(user == null){
			return "{\"result\":\"phone\"}";//帐号不存在
		}
		if(!user.getPassword().equals(MD5Util.decodePasswd(pwd))){
			return "{\"result\":\"pwd\"}";//密码错误
		}
		
		request.getSession().setAttribute("user", user);
		return "{\"result\":\"ok\"}";
	}
	
	
	
	@ResponseBody
	@RequestMapping("/editUser")
	public String editUser(EditUserVO vo ,HttpServletRequest request){
		//空值校验
		if(vo == null || vo.getGender() == null || vo.getAddress() == null 
				|| vo.getEmail() == null || vo.getPostcode() == null || vo.getUsername() == null){
			return null;
		}
		
		User user = (User)request.getSession().getAttribute("user");
		User newUser = new User();
		newUser.setId(user.getId());
		newUser.setAddress(vo.getAddress());
		newUser.setEmail(vo.getEmail());
		newUser.setPostcode(vo.getPostcode());
		newUser.setGender(vo.getGender()?1:0);
		newUser.setUsername(vo.getUsername());
		
		try {
			userService.updateUser(newUser);
			
			user = userService.getUserById(user.getId());
			request.getSession().setAttribute("user", user);//更新session中的user对象
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//修改密码
	@ResponseBody
	@RequestMapping("/changePwd")
	private String changePwd(ChangePwdVO vo,HttpServletRequest request){
		//空值校验
		if(vo == null || vo.getNewpwd() == null || vo.getNewpwd2() == null || vo.getOldpwd() == null){
			return null;
		}
		
		User user = (User)request.getSession().getAttribute("user");
		if(!user.getPassword().equals(MD5Util.decodePasswd(vo.getOldpwd()))){
			return "{\"result\":\"error\"}";//密码错误
		}
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,18}$");
		if(!pattern.matcher(vo.getNewpwd()).matches()){
			return "{\"result\":\"error patteen\"}";//密码格式错误
		}
		if(!vo.getNewpwd().equals(vo.getNewpwd2())){
			return "{\"result\":\"not equal\"}";//密码不相同
		}
		
		int id = user.getId();
		user = new User();
		user.setId(id);
		user.setPassword(MD5Util.decodePasswd(vo.getNewpwd()));
		
		try {
			userService.updateUser(user);
			//更新域内的user对象
			user = userService.getUserById(user.getId());
			request.getSession().setAttribute("user", user);
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//获取当前用户地址信息
	@ResponseBody
	@RequestMapping("/getAddressMessage")
	public Object getAddressMessage(HttpServletRequest request)  throws Exception{
		User user = (User)request.getSession().getAttribute("user");

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			AddressVO vo = userService.getAddressMessage(user.getId());
			map.put("result", "ok");
			map.put("data", vo);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	
	
	
	
	//////////////////////后台管理系统部分
	
	//用户列表
	@RequestMapping("/admin_getUserListPage")
	public String getUserList(Page<User> page,HttpServletRequest request) throws Exception {
		
		try {
			userService.findUsers(page);
		} catch (Exception e) {
			throw new AdminUnknowException("查询用户列表出错",e);
		}
		
		request.setAttribute("pageMap", page.getPageMap());
		request.setAttribute("lastPage", page.getLastPage());
		request.setAttribute("nextPage", page.getNextPage());
		request.setAttribute("totalPage", page.getTotalPage());
		request.setAttribute("currentPage", page.getPage());
		
		//操作成功提示
		if(request.getSession().getAttribute("successTip") != null){
			request.getSession().removeAttribute("successTip");
			request.setAttribute("successTip", true);
		}
		return "forward:/WEB-INF/jsps/admin/user/userList.jsp";
	}
	
	
	
	//冻结/解冻用户操作
	@RequestMapping("/admin_freezeUser")
	public String freezeUser(Integer id,Boolean flag,HttpServletRequest request) throws Exception {
		//空值校验
		if(id == null || flag == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		
		try {
			userService.changeUserFreezeFlag(id, flag);
		} catch (Exception e) {
			throw new AdminUnknowException("修改用户冻结状态失败",e);
		}

		request.getSession().setAttribute("successTip", true);
		return "redirect:/user/admin_getUserListPage";
	}
	
	//用户详细信息页面
	@RequestMapping("/admin_userDetail")
	public String userDetail(Integer id,HttpServletRequest request)throws Exception {
		//空值校验
		if(id == null ){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		
		try {
			UserDetailVO vo  = userService.findUserDetail(id);
			request.setAttribute("userVO", vo);
			return "forward:/WEB-INF/jsps/admin/user/userDetail.jsp";
		} catch (Exception e) {
			throw new AdminUnknowException("根据用户id查询用户失败",e);
		}
	}
	
	//给指定用户增加余额
	@RequestMapping("/admin_addMoney")
	public String addMoney(Integer id,Double money,HttpServletRequest request)throws Exception{
		//空值校验
		if(id == null || money == null ){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		userService.addMoneyToUserById(id, money);
		request.getSession().setAttribute("successTip", true);
		return "redirect:/user/admin_getUserListPage";
	}
	
	//给指定用户扣除余额
	@RequestMapping("/admin_subMoney")
	public String subMoney(Integer id,Double money,HttpServletRequest request)throws Exception{
		//空值校验
		if(id == null || money == null ){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		userService.subMoneyToUserById(id, money);
		request.getSession().setAttribute("successTip", true);
		return "redirect:/user/admin_getUserListPage";
	}
	
}
