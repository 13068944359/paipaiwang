package com.paipaiwang.service;

import java.util.List;
import java.util.Map;

import com.paipaiwang.admin.vo.ItemDetailVO;
import com.paipaiwang.po.Collect;
import com.paipaiwang.po.Item;
import com.paipaiwang.po.Page;
import com.paipaiwang.user.vo.HomepageItemVO;
import com.paipaiwang.user.vo.ItemAuctionStateVO;
import com.paipaiwang.user.vo.ItemPageVO;
import com.paipaiwang.user.vo.PublishVO;
import com.paipaiwang.user.vo.PublishedVO;

//商品
public interface ItemService {
	public void addItem(Item item)throws Exception;//添加商品
	
	public void deleteItemByKey(int key)throws Exception;//删除商品
	
	public Page<Item> findItems(Page<Item> page,boolean verified) throws Exception;//筛选商品
	
	public ItemDetailVO findItemDetailById(int id,boolean verified)throws Exception;//根据id号待审核商品的详细信息
	
	public void verifyItemFinish(int id,boolean flag)throws Exception;//商品审核完成
	
	
	

	public void publishItem(PublishVO vo,String rootPath,int userId)throws Exception;//用户发布商品
	
	public Map<String,Object> getPublishedPage(Page<Item> page)throws Exception;//查看自己发布的商品列表
	
	public ItemPageVO getItemPageVOById(int id)throws Exception;//根据id获取对应商品详情页面
	
	//获取商品详情页中商品的最新状态信息，判断是否已经缴纳保证金，判断商品是否已经开始或者结束拍卖等
	public ItemAuctionStateVO getItemAuctionStateByUseridAndItemId(Integer itemId,Integer UserId)throws Exception;
	
	public List<HomepageItemVO> homepageItem(Integer userId)throws Exception;
	
	//更改商品的收藏状态，flag为真则收藏该商品，如果为假则取消收藏
	public void changeCollect(Integer userId,Integer itemId,Boolean flag)throws Exception;
	
	
	public Map<String,Object> getCollectedItemListMap(Page<Collect> page)throws Exception;
	
	//获取商品分类或者搜索分页   并根据用户id获取该商品是否被收藏
	public Map<String,Object> getSortPage(String sort,String key,Integer page,Integer userId) throws Exception;
}
