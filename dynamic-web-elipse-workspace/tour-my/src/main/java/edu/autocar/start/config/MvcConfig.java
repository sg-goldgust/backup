package edu.autocar.start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import edu.autocar.interceptor.AdminInterceptor;
import edu.autocar.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "edu.autocar" })
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
	}

	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	@Bean
	public AdminInterceptor adminInterceptor() {
		return new AdminInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor()) // 인터셉터 등록
				.addPathPatterns(new String[] { // 적용 url 패턴
						"/admin/**", "/board/**" })
				.excludePathPatterns(new String[] { // 제외 url 패턴
						"/member/avata/*","/board/list", "/board/view/**", "/member/login", "/member/join/**", "member/join_success" });
		registry.addInterceptor(adminInterceptor()) // 인터셉터 등록
				.addPathPatterns("/admin/**"); // 적용 url 패턴
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

	/*
	 * @Override public void configureViewResolvers(ViewResolverRegistry registry) {
	 * // JSP 뷰 리졸러 설정 // 뷰 이름 앞,뒤에 붙일 prefix, surfix 설정
	 * registry.jsp("/WEB-INF/views/", ".jsp"); }
	 */

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(new BeanNameViewResolver());
		
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
		registry.jsp("/WEB-INF/views/", ".jsp"); // prefix, surfix
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles/tiles-layout.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}
}
