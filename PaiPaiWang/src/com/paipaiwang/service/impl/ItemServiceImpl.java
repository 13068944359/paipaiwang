package com.paipaiwang.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.paipaiwang.admin.vo.ItemDetailVO;
import com.paipaiwang.admin.vo.ItemListVO;
import com.paipaiwang.dao.AuctionMapper;
import com.paipaiwang.dao.CollectMapper;
import com.paipaiwang.dao.FreezeMapper;
import com.paipaiwang.dao.ItemMapper;
import com.paipaiwang.dao.OrderMapper;
import com.paipaiwang.dao.TypeMapper;
import com.paipaiwang.dao.UserMapper;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.po.Auction;
import com.paipaiwang.po.Collect;
import com.paipaiwang.po.Freeze;
import com.paipaiwang.po.Item;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.Type;
import com.paipaiwang.po.User;
import com.paipaiwang.service.ItemService;
import com.paipaiwang.user.vo.HomepageItemVO;
import com.paipaiwang.user.vo.ItemAuctionStateVO;
import com.paipaiwang.user.vo.ItemPageVO;
import com.paipaiwang.user.vo.MyAuctionVO;
import com.paipaiwang.user.vo.MyCollectionVO;
import com.paipaiwang.user.vo.PublishVO;
import com.paipaiwang.user.vo.PublishedVO;
import com.paipaiwang.utils.ArithUtil;
import com.paipaiwang.utils.DateUtil;
import com.paipaiwang.utils.FileUtil;

//商品业务模块
@Service
public class ItemServiceImpl implements ItemService {
	
	@Override
	public void addItem(Item item) throws Exception {
		itemMapper.insertSelective(item);
	}

	@Override
	public void deleteItemByKey(int key) throws Exception {
		itemMapper.deleteByPrimaryKey(key);
	}

	@Override
	public Page<Item>  findItems(Page<Item> page,boolean verified) throws Exception {
		if(verified){
			//已审核的
			page.setList(itemMapper.selectVerifiedPageList(page));
			page.setTotalRecord(itemMapper.selectVerifiedPageCount(page));
		}else{
			//未审核的
			page.setList(itemMapper.selectUnverifyPageList(page));
			page.setTotalRecord(itemMapper.selectUnverifyPageCount(page));
		}
		
		//关键字 高亮显示
		List<Item> list = page.getList();
		List<ItemListVO> voList = new LinkedList<ItemListVO>();
		if(list!=null){
			for(Item item:list){
				ItemListVO vo = new ItemListVO();
				
				//id号码，商品名，简介作为检索的关键字段，需要将相关联的关键词进行高亮
				if(page.getKeyWord() != null && !page.getKeyWord().equals("")){
					vo.setId((item.getId()+"").replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
					vo.setName(item.getName().replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
					vo.setBrief(item.getBrief().replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
				}else{
					vo.setId(item.getId()+"");
					vo.setName(item.getName());
					vo.setBrief(item.getBrief());
				}
				
				vo.setOwner(userMapper.selectByPrimaryKey(item.getOwner()).getUsername());
				vo.setPublishTime(item.getPublishTime());
				vo.setStartDate(item.getStartDate());
				vo.setEndDate(item.getEndDate());
				vo.setPrice(item.getPrice());
				
				voList.add(vo);
			}
		}
		page.getPageMap().put("rows",voList);//rows的实体改成vo对象
		
		return page;
	}

	@Override
	public ItemDetailVO findItemDetailById(int id,boolean verified) throws Exception {
		Item item = itemMapper.selectByPrimaryKey(id);
		
		if(!verified && item.getState() != Item.VERIFYING){
			throw new AdminUnknowException("获取的商品所对应的状态并非未审核", null);
		}else if(verified && item.getState() == Item.VERIFYING){
			throw new AdminUnknowException("获取的商品所对应的状态未审核", null);
		}
		
		ItemDetailVO itemDetail = new ItemDetailVO(item);//拷贝基本属性
		itemDetail.setType(typeMapper.selectByPrimaryKey(item.getType()).getName());
		itemDetail.setOwner(userMapper.selectByPrimaryKey(item.getOwner()).getUsername());
		
		if(verified){
			switch(item.getState()){
			case Item.VERIFY_FAIL:		itemDetail.setState("审核不通过");	break;
			case Item.VERIFY_PASS:		itemDetail.setState("审核通过");	break;
			case Item.AUCTIONING:		itemDetail.setState("拍卖中");	break;
			case Item.AUCTION_FAIL:		itemDetail.setState("流拍");		break;
			case Item.AUCTION_SUCCESS:	itemDetail.setState("成交");		break;
			}
		}
		
		return itemDetail;
	}

	//审核完成
	@Override
	public void verifyItemFinish(int id, boolean flag) throws Exception {
		Item item = new Item();
		item.setId(id);
		
		if(flag){
			Item i = itemMapper.selectByPrimaryKey(id);
			Date startDate = i.getStartDate();
			boolean isToday = new DateUtil().isToday(startDate);//判断开始日期是否是今天
			System.out.println("isToday=" + isToday);
			if(isToday){
				item.setState(Item.AUCTIONING);//如果当天立即开始拍卖，则要考虑存储为“拍卖中”状态
			}else{
				item.setState(Item.VERIFY_PASS);
			}
		}else{
			item.setState(Item.VERIFY_FAIL);
		}
		itemMapper.updateByPrimaryKeySelective(item);
	}

	
	//发布商品
	@Override
	public void publishItem(PublishVO vo,String rootPath,int userId) throws Exception {
		//非法值校验
		if(vo.getName().length()>10 || vo.getBrief().length() > 20 || 
				!(vo.getNumber()>=1&&vo.getNumber()<=10000) ){
			throw new Exception();
		}
		if(vo.getPriceAdd()!=10 && vo.getPriceAdd()!=50 && vo.getPriceAdd()!=100 && vo.getPriceAdd()!=500 && vo.getPriceAdd()!=1000){
			throw new Exception();
		}
		
		Item item = new Item();
		item.setName(vo.getName());
		item.setBrief(vo.getBrief());
		item.setPrice(vo.getPrice());
		item.setNumber(vo.getNumber());
		item.setPriceAdd(vo.getPriceAdd());
		item.setOwner(vo.getOwner());
		item.setItemDescription(vo.getItemDescription());
		
		//日期判定
		item.setStartDate(vo.getStartDate());
		item.setEndDate(vo.getEndDate());
		
		if(vo.getPicture1() != null){
			String picture1 = storePicture(vo.getPicture1(),rootPath);
			item.setPicture1(picture1);
		}
		if(vo.getPicture2() != null){
			String picture2 = storePicture(vo.getPicture2(),rootPath);
			item.setPicture2(picture2);
		}
		if(vo.getPicture3() != null){
			String picture3 = storePicture(vo.getPicture3(),rootPath);
			item.setPicture3(picture3);
		}
		if(vo.getIdentifyPicture() != null){
			String identifyPicture = storePicture(vo.getIdentifyPicture(),rootPath);
			item.setIdentifyPicture(identifyPicture);
		}
		
		//type判定
		item.setType(vo.getType());
		
		item.setPublishTime(new Date());
		item.setRemark("备注信息");
		item.setState(0);
		
		//先扣除保证金
		User user = userMapper.selectByPrimaryKey(vo.getOwner());
		if(user == null || user.getUserMoney() < 200){
			throw new Exception();
		}else{
			double newMoney = ArithUtil.sub(user.getUserMoney(),200);
			User newUser = new User();
			newUser.setId(user.getId());
			newUser.setUserMoney(newMoney);
			userMapper.updateByPrimaryKeySelective(newUser);
			
			itemMapper.insertSelective(item);
			//生成冻结金额记录
			if(item.getId() == null){
				throw new Exception();
			}
			Freeze f = new Freeze();
			f.setItemId(item.getId());
			f.setPrice(200.0);
			f.setRemark("");
			f.setType(0);
			f.setUserId(userId);
			freezeMapper.insertSelective(f);
		}
	}
	
	
	//查看自己发布的商品列表
	@Override
	public Map<String,Object> getPublishedPage(Page<Item> page) throws Exception {
		Map<String,Object> map = new HashMap<>();
		
		List<Item> list = itemMapper.selectPublishedPageListByOwnerId(page);
		page.setTotalRecord(itemMapper.selectPublishedPageCountByOwnerId(page));
		map.put("total", page.getTotalPage());
		map.put("page", page.getPage());
		
		List<PublishedVO> voList = new ArrayList<>();
		//封装vo对象
		if(list != null){
			for(Item i : list){
				PublishedVO vo = new PublishedVO(i);
				//设置type
				Type type = typeMapper.selectByPrimaryKey(i.getType());
				vo.setType(type.getName());
				voList.add(vo);
			}
		}
		map.put("data", voList);
		return map;
	}
	
	
	//获取商品竞拍页面的详细商品信息
	@Override
	public ItemPageVO getItemPageVOById(int id) throws Exception {
		
		Item item = itemMapper.selectByPrimaryKey(id);
		//尚在审核的以及审核未通过的都不能被用户看到
		if(item.getState() == Item.VERIFYING || item.getState() == Item.AUCTION_FAIL){
			throw new Exception();
		}
		
		ItemPageVO vo = new ItemPageVO(item);
		
		Type type = typeMapper.selectByPrimaryKey(item.getType());
		String typeName;
		if(type.getParent() != 0){
			Type parentType = typeMapper.selectByPrimaryKey(type.getParent());
			typeName = parentType.getName() + " / " + type.getName();
		}else{
			typeName = type.getName();
		}
		vo.setType(typeName);
		return vo;
	}
	
	//获取商品详情页中商品的最新状态信息，判断是否已经缴纳保证金，判断商品是否已经开始或者结束拍卖等
	@Override
	public ItemAuctionStateVO getItemAuctionStateByUseridAndItemId(Integer itemId, Integer userId)
			throws Exception {
		ItemAuctionStateVO vo = new ItemAuctionStateVO();
		
		Item item = itemMapper.selectByPrimaryKey(itemId);
		if(item.getState()==Item.VERIFYING || item.getState()==Item.AUCTION_FAIL){
			throw new Exception("商品状态非法");
		}
		
		vo.setMine(item.getOwner() == userId );
		
		vo.setState(item.getState());
		Auction auction = auctionMapper.selectLastAuctionByItemId(itemId);
		if(auction != null){
			//已经有人参与竞拍
			vo.setPrice(auction.getPrice());
			vo.setWho(userMapper.selectByPrimaryKey(auction.getUserId()).getUsername());
			//没人竞拍则price和who都为null
		}
		
		if(userId == null){
			//用户未登录则freeze为null
		}else{
			Freeze freeze = freezeMapper.selectBaoZhengJinByUseridAndItemid(userId, itemId);
			if(freeze != null ){
				vo.setFreeze(true);//已经交过保证金了
			}else{
				vo.setFreeze(false);//还没交过保证金了
			}
		}
		return vo;
	}
	
	
	//首页商品列表，需要根据用户id获取是否被收藏
	@Override
	public List<HomepageItemVO> homepageItem(Integer userId) throws Exception {
		List<Item> itemList = itemMapper.selectHomepageItem();
		
		List<HomepageItemVO> newList = new ArrayList<>();
		itemListToHomepageItemVOList(itemList,newList,userId);
		
		return newList;
	}
	
	//更改商品的收藏状态
	@Override
	public void changeCollect(Integer userId, Integer itemId, Boolean flag)
			throws Exception {
		
		Collect c = new Collect();
		c.setUserId(userId);
		c.setItemId(itemId);
		Collect collect = collectMapper.selectByUserIdAndItemId(c);
		
		if(flag){
			if(collect == null){
				//收藏记录为空的时候才需要保存
				c.setCollectTime(new Date());
				collectMapper.insertSelective(c);
			}
		}else{
			if(collect != null){
				//记录存在，才能删除
				collectMapper.deleteByPrimaryKey(collect.getId());
			}
		}
	}
	
	//获取用户收藏品的分页列表  userId 存在page的keyword中
	@Override
	public Map<String, Object> getCollectedItemListMap(Page<Collect> page) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<MyCollectionVO> voList = new ArrayList<MyCollectionVO>();
		
		//总记录数
		int count = collectMapper.selectCountByUserid(page);
		page.setTotalRecord(count);
		map.put("total", page.getTotalPage());//总页数
		map.put("page", page.getPage());
		
		List<Collect> collectList = collectMapper.selectPageByUserid(page);
		for(Collect c:collectList){
			MyCollectionVO vo = new MyCollectionVO();
			
			Item item = itemMapper.selectByPrimaryKey(c.getItemId());
			vo.setId(item.getId());
			vo.setEndDate(new SimpleDateFormat("yyyy/MM/dd").format(item.getEndDate()));
			vo.setName(item.getName());
			vo.setPicture(item.getPicture1());
			
			//如果有竞拍则是竞拍中最新的记录，如果没有就是起拍价
			Auction auction = auctionMapper.selectLastAuctionByItemId(item.getId());
			if(auction != null){
				vo.setCurrentPrice(auction.getPrice());
			}else{
				vo.setCurrentPrice(item.getPrice());
			}
			
			voList.add(vo);
		}
		
		map.put("data", voList);
		return map;
	}
	
	
	
	////////////////////////////////////////////////////////////////////////
	@Override
	public Map<String, Object> getSortPage(String type, String key,
			Integer page, Integer userId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<HomepageItemVO> newList = new ArrayList<HomepageItemVO>();

		Page<Item> queryPage = new Page<Item>();
		queryPage.setPage(page);
		queryPage.setRows(12);//每页12个
		queryPage.setKeyWord(key);//分类id，搜索关键字
		
		List<Item> itemList;
		Integer count;
		if(type.equals("sort")){
			//分类
			itemList = itemMapper.selectItemPageByType(queryPage);
			count= itemMapper.selectItemCountByType(queryPage);
		}else if(type.equals("search")){
			//关键字查找
			itemList = itemMapper.selectItemPageBySearch(queryPage);
			count = itemMapper.selectItemCountBySearch(queryPage);
		}else if(type.equals("everyday")){
			//最后一天
			itemList = itemMapper.selectItemPageByLastDay(queryPage);
			count= itemMapper.selectItemCountByLastDay(queryPage);
		}else{
			throw new Exception();
		}
		queryPage.setTotalRecord(count);
		map.put("total", queryPage.getTotalPage());
		
		itemListToHomepageItemVOList(itemList,newList,userId);
		map.put("data", newList);
		map.put("page", page);
		return map;
	}
	
	private void itemListToHomepageItemVOList(List<Item> itemList,List<HomepageItemVO> newList,Integer userId){
		for(Item i:itemList){
			HomepageItemVO vo = new HomepageItemVO();
			vo.setId(i.getId());
			vo.setPicture(i.getPicture1());
			vo.setName(i.getName());
			vo.setEndDate(new SimpleDateFormat("yyyy/MM/dd").format(i.getEndDate()));
			//如果有竞拍则是竞拍中最新的记录，如果没有就是起拍价
			Auction auction = auctionMapper.selectLastAuctionByItemId(i.getId());
			if(auction != null){
				vo.setCurrentPrice(auction.getPrice());
			}else{
				vo.setCurrentPrice(i.getPrice());
			}
			vo.setCollected(false);
			if(userId!=null){
				//判断是否有收藏记录
				Collect c = new Collect();
				c.setUserId(userId);
				c.setItemId(i.getId());
				Collect collect = collectMapper.selectByUserIdAndItemId(c);
				if(collect!=null){
					vo.setCollected(true);
				}
			}
			newList.add(vo);
		}
	}
	/////////////////////////////////////////////////////////////////////
	
	
	
	
	

	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private TypeMapper typeMapper;
	
	@Autowired
	private AuctionMapper auctionMapper;
	
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private FreezeMapper freezeMapper;
	
	@Autowired
	private CollectMapper collectMapper;


	private String storePicture(MultipartFile f,String rootPath) throws Exception{
		String filename = f.getOriginalFilename();
		int pointLast = filename.lastIndexOf(".");
		String title = filename.substring(0, pointLast);//文件名
		String fileType = filename.substring(pointLast+1,filename.length());//文件类型
		
		UUID uuid = UUID.randomUUID();
		String newFileName = uuid + "." + fileType;
		String targetPath = rootPath + "/picture";
		
		FileUtil.storeFile(f, targetPath, newFileName);
		
		return newFileName;
	}

	
}
