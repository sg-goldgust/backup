package edu.autocar.tourguide.command;

import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

public class SelectTourWithCity implements Command {
	
	public static void main(String[] args) throws Exception {
		TourGuideDao dao = new TourGuideDaoImpl();
		List<String> region = dao.showRegion();
		printRegion(region);
		
		String city = Input.getString("여행지를 찾고자 하는 도시를 선택하세요 : ");
		List<TourGuide> all = dao.selectlist();
		List<TourGuide> select = selectTourWithCity(all,city);
		print(select);
	}
	

	TourGuideDao dao = new TourGuideDaoImpl();

	@Override
	public void execute() throws Exception {
		
		List<String> region = dao.showRegion();
		printRegion(region);

		String city = Input.getString("여행지를 찾고자 하는 도시를 선택하세요 : ");
		List<TourGuide> all = dao.selectlist();
		List<TourGuide> select = selectTourWithCity(all,city);
		print(select);

	}

	static List selectTourWithCity(List<TourGuide> all , String city) {
		List<TourGuide> select = new ArrayList<TourGuide>();
		
		for (TourGuide tg : all) {
			if(tg.getCity().equals(city)) select.add(tg);
		}

		return select;
	}
	
	static void print(List<TourGuide> select) {
		System.out.println("---------------------------------------------------");
		for (TourGuide tg : select) {
			System.out.printf("[%s] %s : %s\n",tg.getRegion(),tg.getName(),tg.getSite());
		}
		System.out.println("---------------------------------------------------");
	}
	
	static void printRegion(List<String> region) {
		System.out.println("---------------------------------------------------");
		for (String r : region) {
			System.out.println(r);
		}
		System.out.println("---------------------------------------------------");
	}

}
