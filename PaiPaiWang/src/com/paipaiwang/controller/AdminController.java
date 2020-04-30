package com.paipaiwang.controller;


import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paipaiwang.admin.vo.AdminLoginVO;
import com.paipaiwang.admin.vo.ChangePWDVO;
import com.paipaiwang.admin.vo.VerifyPictureVO;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.po.Admin;
import com.paipaiwang.po.Page;
import com.paipaiwang.service.AdminService;
import com.paipaiwang.utils.MD5Util;
import com.paipaiwang.utils.VerifyPictureUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	/**
	 * 这部分是登录的
	 */
	
	//后台登录获取验证图片
	@RequestMapping("/getVerifyPicture")
	public String getVerifyPicture(HttpServletRequest request,HttpServletResponse response) throws Exception  {
		//HttpServletResponse response = null;
		ServletOutputStream out = null;
		try {
			// 发头控制浏览器不要缓存(缓存认证图片)
			response.setHeader("expries", "-1");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			out = response.getOutputStream();
			
			VerifyPictureVO verifyPictureVO = new VerifyPictureUtil().getVerifyPictureVO();
//			System.out.println("生成的新验证码："+verifyPictureVO.getVerifyCode());
			request.getSession().setAttribute("verifyCode", verifyPictureVO.getVerifyCode());
			// 图形写给浏览器并刷新session域的验证码
			ImageIO.write(verifyPictureVO.getBufferedImage(), "jpg", out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (Exception e) {
					logger.error("向用户输出验证图片过程出错");
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	//跳转到管理员登录界面
	@RequestMapping("/loginPage")
	public Object loginPage(HttpServletRequest request){
		request.getSession().removeAttribute("admin");
		return "forward:/WEB-INF/jsps/admin/login.jsp";
	}

	//管理员登录接口
	@RequestMapping("/login")
	public String login(AdminLoginVO adminvo,HttpServletRequest request) throws Exception  {
		
		//为了方便测试，先模拟管理员登录
		Admin testAdmin = adminService.findAdminByKey("paipaiwang");
		request.getSession().setAttribute("admin", testAdmin);
		return "redirect:/admin/admin_index";
//		
//		//空值校验
//		if(adminvo == null || adminvo.getUsername()==null ||adminvo.getPassword()==null||adminvo.getVerifyCode()==null){
//			throw new AdminUnknowException("请求关键字段存在空值",null);
//		}
//		System.out.println(adminvo);
//		
//		String username = adminvo.getUsername().trim();
//		String password = adminvo.getPassword().trim();
//		String verifyCode = adminvo.getVerifyCode().trim();
//		//合法值校验
//		boolean flag = false;
//		if("".equals(username)){
//			request.setAttribute("loginMessage", "帐号不能为空");
//			flag = true;
//		}else if("".equals(password)){
//			request.setAttribute("loginMessage", "密码不能为空");
//			flag = true;
//		}else if("".equals(verifyCode)){
//			request.setAttribute("loginMessage", "验证码不能为空");
//			flag = true;
//		}
//		if(flag){
//			return "forward:/WEB-INF/jsps/admin/login.jsp";
//		}
//		
//		//验证码
//		String code = (String) request.getSession().getAttribute("verifyCode");
//		request.getSession().removeAttribute("verifyCode");//验证码是一次性的
//		if(!verifyCode.equals(code)){
//			request.setAttribute("loginMessage", "验证码错误");
//			return "forward:/WEB-INF/jsps/admin/login.jsp";
//		}
//		
//		Admin admin ;
//		try {
//			admin = adminService.findAdminByKey(username);
//		} catch (Exception e) {
////			e.printStackTrace();
//			request.setAttribute("loginMessage", "登录出错");
//			return "forward:/WEB-INF/jsps/admin/login.jsp";
//		}
//		
//		if(admin==null){
//			request.setAttribute("loginMessage", "帐号不存在");
//			return "forward:/WEB-INF/jsps/admin/login.jsp";
//		}
//		if(!admin.getPassword().equals(MD5Util.decodePasswd(password))){
//			request.setAttribute("loginMessage", "密码错误");
//			return "forward:/WEB-INF/jsps/admin/login.jsp";
//		}
//		
//		//能执行到这里说明登录信息正确
//		request.getSession().setAttribute("admin", admin);
//		return "redirect:/admin/admin_index";
	}
	
	
	//管理系统首页
	@RequestMapping("/admin_index")
	public String homepage(){
		return "forward:/WEB-INF/jsps/admin/index.jsp";
	}
	
	//欢迎管理员登录
	@RequestMapping("/admin_welcomePage")
	public String welcomePage() {
		return "forward:/WEB-INF/jsps/admin/welcomePage.jsp";
	}
	
	//修改密码页面
	@RequestMapping("/admin_changePWDPage")
	public String changePWDPage(HttpServletRequest request) {
		request.setAttribute("newPWDError", "密码只能用6-16位的数字或者字母组成");
		return "forward:/WEB-INF/jsps/admin/changePassword.jsp";
	}
	//修改密码页面
	@RequestMapping("/admin_changePWD")
	public String changePWD(ChangePWDVO vo,HttpServletRequest request) throws Exception{
		//空值校验
		if(vo.getOldPWD() == null || vo.getNewPWD() == null || vo.getRepeatPWD() == null ){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		vo.setNewPWD(vo.getNewPWD().trim());
		vo.setOldPWD(vo.getOldPWD().trim());
		vo.setRepeatPWD(vo.getRepeatPWD().trim());
		
		if(!vo.getNewPWD().equals(vo.getRepeatPWD())){
			//新密码重复输入不一致
			request.setAttribute("newPWDError", "新密码重复输入不一致");
			request.setAttribute("repeatPWDError", "新密码重复输入不一致");
			return "forward:/WEB-INF/jsps/admin/changePassword.jsp";
		}
		
		String pRule = "^[0-9a-zA-Z]{6,16}$";//密码只能用6-16位的数字或者字母组成
		if(!vo.getNewPWD().matches(pRule)){
			//新密码不符合格式要求
			request.setAttribute("newPWDError", "密码只能用6-16位的数字或者字母组成");
			return "forward:/WEB-INF/jsps/admin/changePassword.jsp";
		}
		
		Admin admin = (Admin)request.getSession().getAttribute("admin");
		if(!admin.getPassword().equals( MD5Util.decodePasswd( vo.getOldPWD() ) ) ){
			request.setAttribute("oldPWDError", "原密码错误");
			return "forward:/WEB-INF/jsps/admin/changePassword.jsp";
		}
		
		admin.setPassword( MD5Util.decodePasswd( vo.getNewPWD() ) ); 
		//不更新多余的信息
		admin.setCreateTime(null);
		admin.setRemark(null);
		admin.setSuperUser(null);
		try {
			adminService.updateAdmin(admin);
		} catch (Exception e) {
			throw new AdminUnknowException("修改管理员密码失败",e);
		}

		return "redirect:/admin/admin_welcomePage";
	}
	
	
	
	/**
	 * 这部分是管理员管理的 
	 */
	
	//管理员管理
	@RequestMapping("/super_getAdminListPage")
	public String getAdminListPage(Page<Admin> page,HttpServletRequest request) throws Exception {
		try {
			adminService.findAdmins(page);
		} catch (Exception e) {
//			e.printStackTrace();
			throw new AdminUnknowException("查询管理员列表出错",e);
		}
		
		request.setAttribute("pageMap", page.getPageMap());
		request.setAttribute("lastPage", page.getLastPage());
		request.setAttribute("nextPage", page.getNextPage());
		request.setAttribute("totalPage", page.getTotalPage());
		request.setAttribute("currentPage", page.getPage());
		
		if(request.getSession().getAttribute("successTip") != null){
			request.getSession().removeAttribute("successTip");
			System.out.println("yes have tip");
			request.setAttribute("successTip", true);
		}
		
		return "forward:/WEB-INF/jsps/admin/admin/adminList.jsp";
	}
	
	//添加管理员页面
	@RequestMapping("/super_addAdminPage")
	public String addAdminPage() throws Exception{
		return "forward:/WEB-INF/jsps/admin/admin/addAdmin.jsp";
	}
	
	//添加管理员
	@RequestMapping("/super_addAdmin")
	public String addAdmin(Admin admin,HttpServletRequest request) throws Exception{
		//空值校验
		if(admin == null || admin.getUsername() == null || admin.getPassword() == null || admin.getRemark() == null || admin.getSuperUser() == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		
		admin.setUsername(admin.getUsername().trim());
		admin.setPassword(admin.getPassword().trim());
		admin.setRemark(admin.getRemark().trim());
		
		boolean flag = false;//合法性校验标志位
		
		String upRule = "^[0-9a-zA-Z]{6,16}$";//用户名和密码只能用6-16位的数字或者字母组成
		//用户名
		if(!admin.getUsername().matches(upRule)){
			flag = true;
			request.setAttribute("usernameError", "只能用6-16位的数字或者字母组成");
		}else if(adminService.findAdminByKey(admin.getUsername())!=null){
			flag = true;
			request.setAttribute("usernameError", "用户名已存在");
		}
		//密码
		if(!admin.getPassword().matches(upRule)){
			flag = true;
			request.setAttribute("passwordError", "只能用6-16位的数字或者字母组成");
		}
		//备注信息
		if(admin.getRemark().length() > 100){
			flag = true;
			request.setAttribute("remarkError", "不能多于100个字符");
		}
		
		if(flag){
			//未能通过校验，返回页面
			return "forward:/WEB-INF/jsps/admin/admin/addAdmin.jsp";
		}
		
		admin.setCreateTime(new Date());//校验合法，补全信息后添加入数据库
		admin.setPassword(MD5Util.decodePasswd(admin.getPassword()));
		try{
			adminService.addAdmin(admin);
		}catch(Exception e){
			throw new AdminUnknowException("添加用户失败",e);
		}

		request.getSession().setAttribute("successTip", true);
		return "redirect:/admin/super_getAdminListPage";//添加成功直接返回管理员列表页
	}

	//删除管理员
	@RequestMapping("/super_deleteAdmin")
	public String deleteAdmin(String username,HttpServletRequest request) throws Exception{
		try {
			adminService.deleteAdminByKey(username);
		} catch (Exception e) {
			throw new AdminUnknowException("删除管理员出错", e);
		}
		request.getSession().setAttribute("successTip", true);
		return "redirect:/admin/super_getAdminListPage";//删除成功直接返回管理员列表页
	}
	
	//编辑管理员信息
	@RequestMapping("/super_editAdminPage")
	public String editAdminPage(String username,HttpServletRequest request) throws Exception{
		Admin admin;
		try {
			admin = adminService.findAdminByKey(username);
		} catch (Exception e) {
			throw new AdminUnknowException("查询管理员出错", e);
		}
		
		if(admin == null){
			throw new AdminUnknowException("根据用户名获取不到管理员信息", null);
		}
		request.setAttribute("admin", admin);

		return "forward:/WEB-INF/jsps/admin/admin/editAdmin.jsp";
	}
	
	//更新管理员信息
	@RequestMapping("/super_updateAdmin")
	public String updateAdmin(Admin admin,HttpServletRequest request) throws Exception{
		//空值校验
		if(admin.getUsername() == null ||  admin.getRemark() == null || admin.getSuperUser() == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		
		//备注信息合法性校验
		if(admin.getRemark().length() > 100){
			request.setAttribute("remarkError", "不能多于100个字符");
			return "forward:/WEB-INF/jsps/admin/admin/editAdmin.jsp";
		}
		
		admin.setCreateTime(null);//无关字段不予更新
		admin.setPassword(null);//无关字段不予更新

		try {
			adminService.updateAdmin(admin);
		} catch (Exception e) {
			throw new AdminUnknowException("更新管理员出错", e);
		}
		request.getSession().setAttribute("successTip", true);
		return "redirect:/admin/super_getAdminListPage";//更新成功直接返回管理员列表页
	}
	
	
	//更新管理员信息
	@RequestMapping("/super_resetPassword")
	public String resetPassword(String username,HttpServletRequest request) throws Exception{
		//空值校验
		if(username == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(MD5Util.decodePasswd("paipaiwang"));
		try {
			adminService.updateAdmin(admin);
		} catch (Exception e) {
			throw new AdminUnknowException("更新管理员出错", e);
		}
		
		request.getSession().setAttribute("successTip", true);
		return "redirect:/admin/super_getAdminListPage";//更新成功直接返回管理员列表页
	}
	
	

	private Logger logger = LogManager.getLogger(getClass());
	
}
