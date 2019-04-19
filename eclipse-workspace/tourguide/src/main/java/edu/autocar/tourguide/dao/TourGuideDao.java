package edu.autocar.tourguide.dao;

import java.util.List;

import edu.autocar.base.database.CrudDao;
import edu.autocar.base.database.PaginationDao;
import edu.autocar.tourguide.domain.TourGuide;

public interface TourGuideDao extends CrudDao<TourGuide, String>, PaginationDao<TourGuide> {
	
	public TourGuide selectName(String key) throws Exception ;
	
	public List<TourGuide> search(String city , String keyword) throws Exception;
	
	public List<String> showRegion() throws Exception;
	
}
