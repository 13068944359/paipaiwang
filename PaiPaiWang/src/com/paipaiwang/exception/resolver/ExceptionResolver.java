package com.paipaiwang.exception.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.paipaiwang.exception.AdminUnknowException;

public class ExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex) {
		
		ex.printStackTrace();
		
		
		ModelAndView modelAndView = null;
		if(ex instanceof AdminUnknowException){
			Exception exception = ((AdminUnknowException)ex).getException();
			if(exception!=null){
				exception.printStackTrace();
			}
			//向前台返回错误信息
	        modelAndView = new ModelAndView();
	        modelAndView.setViewName("/WEB-INF/jsps/admin/unknowError.jsp");
		}else{
			System.out.println("ex");
			ex.printStackTrace();
		}
		
		
		
		return modelAndView;
	}

}
