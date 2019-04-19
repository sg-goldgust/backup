package edu.autocar.tourguide.command;

import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

public class SelectTourWithName implements Command {
	
	public static void main(String[] args) throws Exception {
		
		TourGuideDao dao = new TourGuideDaoImpl();
		
		String name = Input.getString("찾고자 하는 여행장소를 입력하세요 : ");
		
		TourGuide tg = dao.selectName(name);
		assert tg != null : "입력한 여행장소가 없습니다.";
		System.out.printf("[%s] %s : %s\n",tg.getRegion(),tg.getName(),tg.getSite());

	}
	
	TourGuideDao dao = new TourGuideDaoImpl();

	@Override
	public void execute() throws Exception {
		
		String name = Input.getString("찾고자 하는 여행장소를 입력하세요 : ");
		TourGuide tg = dao.selectName(name);
		assert tg == null : "입력한 여행장소가 없습니다.";
		System.out.println("---------------------------------------------------");
		System.out.printf("[%s] %s : %s\n",tg.getRegion(),tg.getName(),tg.getSite());
		System.out.println("---------------------------------------------------");
	}
	//이름으로 여행장소 정보 찾기
	
	
}
