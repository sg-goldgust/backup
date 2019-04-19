package edu.autocar.start.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] { RootConfig.class , DatabaseConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		String contextPath = servletContext.getContextPath();
		servletContext.setAttribute("contextPath", contextPath);

		FilterRegistration charEncodingFilterReg = servletContext.addFilter("CharacterEncodingFilter",
				CharacterEncodingFilter.class);
		charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
		charEncodingFilterReg.setInitParameter("forceEncoding", "true");
		charEncodingFilterReg.addMappingForUrlPatterns(null, true, "/*");
	}

	
	

}
