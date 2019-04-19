package spring_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring_test.app.AppMain;
import spring_test.dao.ArticleDao;
import spring_test.dao.ArticleDaoImpl;
import spring_test.service.ArticleService;
import spring_test.service.ArticleServiceImpl;




@Configuration
@ComponentScan(basePackages = {
		"spring_test"
})
public class AppConfig {
	/*
	 * @Bean public ArticleDao articleDao() { return new ArticleDaoImpl(); }
	 * 
	 * @Bean public ArticleService articleService() { return new
	 * ArticleServiceImpl(articleDao()); }
	 * 
	 * @Bean public ArticleService articleSerivce2() { ArticleServiceImpl service =
	 * new ArticleServiceImpl(); service.setArticleDao(articleDao()); return
	 * service; }
	 * 
	 * @Bean(name = "app") public AppMain getApp() { return new
	 * AppMain(articleService()); }
	 */	 
}
