package edu.autocar.start.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"edu.autocar"})
public class MvcConfig implements WebMvcConfigurer {
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	// JSP 뷰 리졸러 설정
	// 뷰 이름 앞,뒤에 붙일 prefix, surfix 설정
	registry.jsp("/WEB-INF/views/", ".jsp");
	}
}
