package com.paipaiwang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipaiwang.admin.vo.UserDetailVO;
import com.paipaiwang.dao.FreezeMapper;
import com.paipaiwang.dao.ItemMapper;
import com.paipaiwang.dao.OrderMapper;
import com.paipaiwang.dao.UserMapper;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.po.Freeze;
import com.paipaiwang.po.Item;
import com.paipaiwang.po.Order;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.service.UserService;
import com.paipaiwang.user.vo.AddressVO;
import com.paipaiwang.utils.ArithUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private FreezeMapper freezeMapper;
	
	
	@Override
	public User findUserByMobile(String mobileNum) throws Exception {
		return userMapper.selectByMobilephone(mobileNum);
	}

	@Override
	public void deleteUserById(int key) throws Exception {
		userMapper.deleteByPrimaryKey(key);
	}

	@Override
	public void updateUser(User user)  throws Exception{
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void addUser(User user) throws Exception {
		userMapper.insertSelective(user);
	}

	
	@Override
	public UserDetailVO findUserDetail(Integer userId) throws Exception {
		UserDetailVO vo = new UserDetailVO();
		User user = userMapper.selectByPrimaryKey(userId);
		
		vo.setUser(user);
		
		Page<Item> pageItem = new Page<Item>();
		pageItem.setKeyWord(user.getId() + ""); 
		int publishedCount = itemMapper.selectPublishedPageCountByOwnerId(pageItem);
		vo.setPublished(publishedCount);
		
		Page<Order> pageOrder = new Page<Order>();
		pageOrder.setKeyWord(user.getId() + "");
		int buyOrderCount = orderMapper.selectBuyOrderCountByUserId(pageOrder);
		vo.setBought(buyOrderCount);
		
		List<Freeze> list = freezeMapper.selectAllFreezeByUserId(userId);
		double freezeMoney = 0.0;
		for(Freeze f : list){
			freezeMoney = ArithUtil.add(freezeMoney, f.getPrice());
		}
		vo.setFreeze(freezeMoney);
		return vo;
	}
	
	@Override
	public Double getAllFreezeMoneyByUserId(Integer userId) throws Exception {
		List<Freeze> list = freezeMapper.selectAllFreezeByUserId(userId);
		double freezeMoney = 0.0;
		for(Freeze f : list){
			freezeMoney = ArithUtil.add(freezeMoney, f.getPrice());
		}
		return freezeMoney;
	}
	
	
	@Override
	public Page<User> findUsers(Page<User> page) throws Exception {
		page.setList(userMapper.selectPageList(page));
		//关键字高亮显示
		if(page.getKeyWord()!=null && !page.getKeyWord().equals("")){
			List<User> list = page.getList();
			if(list!=null){
				for(User user:list){
					user.setMobiphone(user.getMobiphone().replaceAll(page.getKeyWord(),"<span style='color:red;'>"+page.getKeyWord()+"</span>"));
					user.setUsername(user.getUsername().replaceAll(page.getKeyWord(),  "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
					user.setRealname(user.getRealname().replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
					user.setIdcard(user.getIdcard().replaceAll(page.getKeyWord(),  "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
					user.setEmail(user.getEmail().replaceAll(page.getKeyWord(),  "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
				}
			}
		}
		page.setTotalRecord(userMapper.selectPageCount(page));
		return page;
	}

	@Override
	public void changeUserFreezeFlag(int id,boolean flag) throws Exception {
		User user = new User();
		user.setId(id);
		user.setFreeze(flag);
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User getUserById(int id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addMoneyToUserById(int id, double money) throws Exception {
		User user = userMapper.selectByPrimaryKey(id);
		if(user == null){
			throw new AdminUnknowException("要增加余额的账户id不存在", null);
		}
		money = ArithUtil.round(money, 2);//四舍五入小数点后两位
		double newMoney = ArithUtil.add(money, user.getUserMoney());
		
		User newUser = new User();
		newUser.setId(id);
		newUser.setUserMoney(newMoney);
		userMapper.updateByPrimaryKeySelective(newUser);
	}

	@Override
	public void subMoneyToUserById(int id, double money) throws Exception {
		User user = userMapper.selectByPrimaryKey(id);
		if(user == null){
			throw new AdminUnknowException("要增加余额的账户id不存在", null);
		}
		money = ArithUtil.round(money, 2);//四舍五入小数点后两位
		
		double newMoney = ArithUtil.sub(user.getUserMoney(),money);
		if(newMoney < 0){
			throw new AdminUnknowException("余额不够扣", null);
		}
		User newUser = new User();
		newUser.setId(id);
		newUser.setUserMoney(newMoney);
		userMapper.updateByPrimaryKeySelective(newUser);
	}
	
	
	@Override
	public AddressVO getAddressMessage(Integer userId) throws Exception {
		User user = userMapper.selectByPrimaryKey(userId);
		
		AddressVO vo = new AddressVO();
		vo.setUsername(user.getUsername());
		vo.setPhone(user.getMobiphone());
		vo.setAddress(user.getAddress());
		vo.setPostcode(user.getPostcode());
		
		return vo;
	}

	@Override
	public synchronized void recharge(Integer userId, Double money) throws Exception {
		if(money <= 0){
			throw new Exception("非法值");
		}
		User user = userMapper.selectByPrimaryKey(userId);
		Double newMoney = ArithUtil.add(user.getUserMoney(), money);
		
		User new_user = new User();
		new_user.setId(userId);
		new_user.setUserMoney(newMoney);
		
		userMapper.updateByPrimaryKeySelective(new_user);//更新用户余额
	}

}
