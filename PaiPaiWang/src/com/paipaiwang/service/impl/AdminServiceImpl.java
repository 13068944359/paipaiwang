package com.paipaiwang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipaiwang.dao.AdminMapper;
import com.paipaiwang.po.Admin;
import com.paipaiwang.po.Page;
import com.paipaiwang.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	
	@Override
	public void addAdmin(Admin admin) throws Exception {
		adminMapper.insertSelective(admin);
	}

	@Override
	public void deleteAdminByKey(String key) throws Exception {
		adminMapper.deleteByPrimaryKey(key);
	}

	@Override
	public Admin findAdminByKey(String key) throws Exception{
		return adminMapper.selectByPrimaryKey(key);
	}

	@Override
	public void updateAdmin(Admin admin) throws Exception{
		adminMapper.updateByPrimaryKeySelective(admin);
	}

	
	
	@Override
	public Page<Admin> findAdmins(Page page) throws Exception {
		page.setList(adminMapper.selectPageList(page));
		//将关键字高亮显示
		if(page.getKeyWord()!=null && !page.getKeyWord().equals("")){
			List<Admin> list = page.getList();
			if(list!=null){
				for(Admin admin : list){
					admin.setUsername(admin.getUsername().replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
					admin.setRemark(admin.getRemark().replaceAll(page.getKeyWord(), "<span style='color:red;'>"+page.getKeyWord()+"</span>"));
				}
			}
		}
		page.setTotalRecord(adminMapper.selectPageCount(page));
		return page;
	}

}
