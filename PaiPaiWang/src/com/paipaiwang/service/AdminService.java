package com.paipaiwang.service;
import org.springframework.stereotype.Service;

import com.paipaiwang.po.Admin;
import com.paipaiwang.po.Page;


//管理员
public interface AdminService {
	
	public void addAdmin(Admin admin) throws Exception;//添加管理员
	
	public void deleteAdminByKey(String key) throws Exception;//删除管理员
	
	public Admin findAdminByKey(String key) throws Exception;//根据主键查询管理员
	
	public void updateAdmin(Admin admin) throws Exception;//更新管理员信息
	
	public Page<Admin> findAdmins(Page page)throws Exception;//查找管理员
	
}
