package com.paipaiwang.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paipaiwang.admin.vo.ItemListVO;
import com.paipaiwang.dao.AuctionMapper;
import com.paipaiwang.dao.TypeMapper;
import com.paipaiwang.po.Auction;
import com.paipaiwang.po.Collect;
import com.paipaiwang.po.Item;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.Type;
import com.paipaiwang.service.ItemService;

public class TestItemService {
	static ApplicationContext context;
	static{
		context =new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testAdd() throws Exception{
		ItemService itemService = context.getBean(ItemService.class);
		
		Item item = new Item();
		item.setBrief("简介");
		item.setEndDate(new Date());
		item.setIdentifyPicture("abc.jpg");
		item.setItemDescription("详细描述的内容详细描述的内容详细描述的内容详细描述的内容详细描述的内容详细描述的内容详细描述的内容详细描述的内容");
		item.setName("商品 名称");
		item.setNumber(1);
		item.setOwner(1);
		item.setPicture1("abc.jpg");
		item.setPicture2("abc.jpg");
		item.setPicture3("abc.jpg");
		item.setPrice(1000.00);
		item.setPriceAdd(100.00);
		item.setPublishTime(new Date());
		item.setRemark("备注信息");
		item.setStartDate(new Date());
		item.setState(1);
		item.setType(1);
		for(int i = 1000000026;i<=1000000028;i++){
			item.setId(i);
			itemService.addItem(item);
		}
		
	}
	
	
	@Test
	public void testPage() throws Exception{
		ItemService itemService = context.getBean(ItemService.class);
		Page<Item> page = new Page<Item>();
		page.setPage(1);
		itemService.findItems(page,true);
		System.out.println(page);
		List<ItemListVO> list = (List<ItemListVO>) page.getPageMap().get("rows");
		System.out.println(list.size());
		for(ItemListVO vo : list){
			System.out.println(vo);
		}
	}
	
	
	
	
	@Test
	public void testAddItemType(){
		TypeMapper typeMapper = context.getBean(TypeMapper.class);
		Type type ;

		////////////////////////////////
		type = new Type(1, "书法绘画", 0, null);
		typeMapper.insertSelective(type);
		
		type = new Type(2, "绘画", 1, null);
		typeMapper.insertSelective(type);
		type = new Type(3, "书法", 1, null);
		typeMapper.insertSelective(type);
		type = new Type(4, "古籍文献", 1, null);
		typeMapper.insertSelective(type);
		
		////////////////////////////////
		type = new Type(5, "西画雕塑", 0, null);
		typeMapper.insertSelective(type);
		
		type = new Type(6, "油画", 5, null);
		typeMapper.insertSelective(type);
		type = new Type(7, "水彩", 5, null);
		typeMapper.insertSelective(type);
		type = new Type(8, "雕塑", 5, null);
		typeMapper.insertSelective(type);

		////////////////////////////////
		type = new Type(9, "古瓷珠宝", 0, null);
		typeMapper.insertSelective(type);
		
		type = new Type(10, "玉器", 9, null);
		typeMapper.insertSelective(type);
		type = new Type(11, "陶瓷", 9, null);
		typeMapper.insertSelective(type);
		type = new Type(12, "木器", 9, null);
		typeMapper.insertSelective(type);

		////////////////////////////////
		type = new Type(13, "当代工艺", 0, null);
		typeMapper.insertSelective(type);
		
		type = new Type(14, "珠宝", 13, null);
		typeMapper.insertSelective(type);
		type = new Type(15, "金属器", 13, null);
		typeMapper.insertSelective(type);

		////////////////////////////////
		type = new Type(16, "各类杂货", 0, null);
		typeMapper.insertSelective(type);

		////////////////////////////////
		type = new Type(17, "二手商品", 0, null);
		typeMapper.insertSelective(type);
	}
	
	
	@Test
	public void testCollectPage() throws Exception{
		ItemService itemService = context.getBean(ItemService.class);
		
		Page<Collect> page = new Page<Collect>();
		page.setKeyWord("23");
		itemService.getCollectedItemListMap(page);
	}
	
	
	@Test
	public void testActionByItemID(){
		AuctionMapper auctionMapper = context.getBean(AuctionMapper.class);
		Auction auction = auctionMapper.selectLastAuctionByItemId(100000001);
		System.out.println(auction);
	}
	
	@Test
	public void testSort() throws Exception{
		ItemService itemService = context.getBean(ItemService.class);
		
//		Map<String, Object> map = itemService.getSortPage("sort", "16", 1, null);
//		System.out.println(map);
		
		Map<String, Object> map = itemService.getSortPage("search", "测试", 1, null);
		System.out.println(map.get("data"));
		
	}
	
}
