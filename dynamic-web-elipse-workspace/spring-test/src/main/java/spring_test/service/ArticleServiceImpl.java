package spring_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_test.dao.ArticleDao;
import spring_test.dao.ArticleDaoImpl;
import spring_test.domain.Article;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	ArticleDao dao;
	public ArticleServiceImpl() {
	
	}

	/*
	 * public ArticleServiceImpl(ArticleDao dao) { this.dao = dao; }
	 * 
	 * public void setArticleDao(ArticleDao dao) { this.dao = dao; }
	 */
	@Override
	public void insert(Article article) {
		System.out.println("> Article Service : 글 저장");
		dao.insert(article);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article selectOne(int id) {
		// TODO Auto-generated method stub
		System.out.println("> Article service :  글 추출");
		return dao.selectOne(id);
	}

}
