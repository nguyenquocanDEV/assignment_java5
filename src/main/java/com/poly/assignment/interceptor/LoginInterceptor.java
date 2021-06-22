package com.poly.assignment.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		request.getSession().setAttribute("secureUri", request.getRequestURI());
		if (uri.contains("site")) {
			System.err.println("site");
			if (request.getSession().getAttribute("customer") == null) {
				response.sendRedirect("/site/logins");
				return false;
			} 
		} else {
			System.err.println("admin");
			if (request.getSession().getAttribute("account") == null) {
				System.err.println("admin");
				System.out.println(uri);
				response.sendRedirect("/admin/logins");
				return false;
			}
		}
		
		return true;
	}

}
