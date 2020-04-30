package com.paipaiwang.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipaiwang.admin.vo.AdvUpdateVO;
import com.paipaiwang.dao.AdvertisementMapper;
import com.paipaiwang.po.Advertisement;
import com.paipaiwang.service.AdvService;
import com.paipaiwang.utils.FileUtil;

@Service
public class AdvServiceImpl implements AdvService{

	@Autowired
	private AdvertisementMapper advMapper;
	
	@Override
	public void addAdv(Advertisement adv) throws Exception {
		advMapper.insertSelective(adv);
	}

	@Override
	public void updateAdv(AdvUpdateVO adv,String rootPath) throws Exception {
		String newFileName = UUID.randomUUID() + ".jpg";//uuid为新的文件名
		FileUtil.storeFile(adv.getPicture(), rootPath +"/picture", newFileName);//保存图片文件到picture文件夹
		
		Advertisement advertisement = new Advertisement();
		advertisement.setId(adv.getId());
		advertisement.setCreateTime(new Date());
		advertisement.setPicture(newFileName);
		advertisement.setTitle(adv.getTitle());
		advertisement.setUrl(adv.getUrl());
		
		//先删除原来的图片文件
//		String oldPic = advMapper.selectByPrimaryKey(adv.getId()).getPicture();
//		FileUtil.deleteFile(rootPath + "/picture/" + oldPic);
		
		advMapper.updateByPrimaryKeySelective(advertisement);
	}

	@Override
	public List<Advertisement> getAdvs() throws Exception {
		return advMapper.getAll();
	}

	@Override
	public Advertisement findAdvById(int id) throws Exception {
		return advMapper.selectByPrimaryKey(id);
	}

}
