package com.hr.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class StudentInterceptor extends HandlerInterceptorAdapter {
	
	
	
	
	/**
	 * Before handling any request process this intercepter.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar objCalendar = Calendar.getInstance();
		// getting day on which request has been made
		int dayofWeek = objCalendar.get(objCalendar.DAY_OF_WEEK);
		// here 1 = Sunday
		if (dayofWeek == 1) {
			response.getWriter().write("You can not access this page on Sunday !");
			return false;
		}
		return true;
	}
	
	

}
