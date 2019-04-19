package edu.autocar.tourguide.command;

import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

public class SelectTourWithContent implements Command {
	
	public static void main(String[] args) throws Exception {
		TourGuideDao dao = new TourGuideDaoImpl();
		String city = Input.getString("검색하고자 하는 지역을 입력하세요 : ");
		String search = Input.getString("특정 내용을 포함하고 싶은 단어를 입력하세요 : ");
		List<TourGuide> select = dao.search(city, search);
		print(select);
	}
	
	TourGuideDao dao = new TourGuideDaoImpl();

	@Override
	public void execute() throws Exception {
		String city = Input.getString("검색하고자 하는 지역을 입력하세요 : ");
		String search = Input.getString("특정 내용을 포함하고 싶은 단어를 입력하세요 : ");
		List<TourGuide> select = dao.search(city, search);
		print(select);

	}
	
	static void print(List<TourGuide> select) {
		System.out.println("---------------------------------------------------");
		for (TourGuide tg : select) {
			System.out.printf("[%s] %s : %s\n",tg.getRegion(),tg.getName(),tg.getSite());
		}
		System.out.println("---------------------------------------------------");
	}
	
	
}
