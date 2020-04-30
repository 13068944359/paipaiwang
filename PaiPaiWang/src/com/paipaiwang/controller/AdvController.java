package com.paipaiwang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paipaiwang.admin.vo.AdvUpdateVO;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.po.Advertisement;
import com.paipaiwang.service.AdvService;

@Controller
@RequestMapping("/adv")
public class AdvController {
	
	@Autowired
	private AdvService advService;
	
	
	//首页获取的几张广告轮播图
	@ResponseBody
	@RequestMapping("/advPictures")
	public Object advPictures() throws Exception{
		
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			map.put("result", "ok");
			map.put("data", advService.getAdvs());
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	
	
	
	
	
	////////////////////后台管理
	
	//广告轮播图管理列表页面
	@RequestMapping("/admin_getAdvertisementListPage")
	public String getAdvertisementList(HttpServletRequest request) throws Exception {
		List<Advertisement> advs;
		try {
			advs = advService.getAdvs();
		} catch (Exception e) {
			throw new AdminUnknowException("查询轮播图列表出错",e);
		}
		request.setAttribute("rows", advs);
		
		//操作成功提示
		if(request.getSession().getAttribute("successTip") != null){
			request.getSession().removeAttribute("successTip");
			request.setAttribute("successTip", true);
		}
		return "forward:/WEB-INF/jsps/admin/advertisement/advertisementList.jsp";
	}

	//编辑轮播图页面
	@RequestMapping("/admin_editAdvPage")
	public String editAdv(Integer id,HttpServletRequest request)throws Exception {
		//空值校验
		if(id == null ){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		
		Advertisement adv = advService.findAdvById(id);
		request.setAttribute("adv", adv);
		return "forward:/WEB-INF/jsps/admin/advertisement/editAdv.jsp";
	}
	
	
	//更新轮播图
	@RequestMapping("/admin_updateAdv")
	public String updateAdv(AdvUpdateVO advVO,HttpServletRequest request)throws Exception {
		System.out.println("admin_updateAdv");
		System.out.println(advVO);
		//空值校验
		if(advVO == null || advVO.getId() == null || advVO.getPicture() == null || advVO.getTitle() == null || advVO.getUrl() == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		//判断文件类型是否正确
		String filename = advVO.getPicture().getOriginalFilename();
		int pointLast = filename.lastIndexOf(".");
		String fileType = filename.substring(pointLast+1,filename.length());//文件类型
		if(!fileType.equals("jpg")){
			throw new AdminUnknowException("用户上传图片不是Jpg格式", null);
		}

		String rootPath = request.getSession().getServletContext().getRealPath("/");
		try {
			advService.updateAdv(advVO,rootPath);
		} catch (Exception e) {
			throw new AdminUnknowException("更新广告轮播图出错",e);
		}
		
		request.getSession().setAttribute("successTip", true);
		return "redirect:/adv/admin_getAdvertisementListPage";
	}
	
	
}
