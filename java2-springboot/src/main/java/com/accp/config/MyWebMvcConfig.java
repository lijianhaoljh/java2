package com.accp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.accp.intercetor.MyInterceptor;

@Configuration
public class MyWebMvcConfig extends WebMvcConfigurationSupport {
	
	

//	classpath:static
//	classpath:resources
//	classpath:META-INF/public
//	classpath:public
//	覆盖原有的静态资源配置，必须重新配置

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/")
				.addResourceLocations("file:/Users/tangyong/images/");
		super.addResourceHandlers(registry);
	}

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowedHeaders("*").allowCredentials(true);
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
