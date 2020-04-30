package com.paipaiwang.service;

import java.util.List;

import com.paipaiwang.admin.vo.UserDetailVO;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.user.vo.AddressVO;

//用户管理
public interface UserService {

	public User findUserByMobile(String mobileNum) throws Exception;//根据手机号查找
	
	public User getUserById(int id)throws Exception;//根据主键查找
	
	public void deleteUserById(int key) throws Exception;//根据主键删除
	
	public void updateUser(User user) throws Exception;//更新用户信息
	
	
	public Double getAllFreezeMoneyByUserId(Integer userId)throws Exception;//获取用户冻结总金额
	
	public void recharge(Integer userId,Double money)throws Exception;//用户余额充值
	
	public void addUser(User user) throws Exception;//添加用户
	
	public UserDetailVO findUserDetail(Integer userId)throws Exception;//获取用户详细信息（包括订单数量）
	
	public Page<User> findUsers(Page<User> page) throws Exception;//查找用户
	
	public void changeUserFreezeFlag(int id,boolean flag) throws Exception;//改变帐号冻结状态
	
	public void addMoneyToUserById(int id,double money) throws Exception;//账户余额增加
	
	public void subMoneyToUserById(int id,double money) throws Exception;//账户余额减少
	
	public AddressVO getAddressMessage(Integer userId) throws Exception;//获取用户用于接收快递用的地址信息
}
