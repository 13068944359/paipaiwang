package com.paipaiwang.service;

import java.util.List;

import com.paipaiwang.admin.vo.AdvUpdateVO;
import com.paipaiwang.po.Advertisement;

//广告轮播图
public interface AdvService {
	public void addAdv(Advertisement adv) throws Exception;//添加
	
	public void updateAdv(AdvUpdateVO adv,String rootPath) throws Exception;//更新
	
	public List<Advertisement> getAdvs() throws Exception;//获取所有广告对象
	
	public Advertisement findAdvById(int id) throws Exception;//根据id获取对应的广告轮播图信息
}
