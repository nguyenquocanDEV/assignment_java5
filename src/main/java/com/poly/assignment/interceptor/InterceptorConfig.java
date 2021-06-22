package com.poly.assignment.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Autowired
	LoginInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(interceptor)
		.addPathPatterns("/site/orders/**","/site/customers/**")
		.addPathPatterns("/admin/**")
		.excludePathPatterns("/site/home/**","/site/customers/add/**","/admin/logins/**");
		
	}
	
}
