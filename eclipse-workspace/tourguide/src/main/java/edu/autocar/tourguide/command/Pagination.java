package edu.autocar.tourguide.command;

import java.util.List;

import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

public class Pagination implements Command {


	TourGuideDao dao = new TourGuideDaoImpl();
	final static int size = 10;
	@Override
	public void execute() throws Exception {

		
		int page = Input.getInt("찾아볼 페이지를 입력하세요 : ");
		int next;

		viewPage(size, page);

		do {
			next = Input.getInt("선택[다음페이지(1),이전페이지(2),종료(3)] : ");
			switch (next) {
			case 1:
				page++;
				viewPage(size, page);
				break;
			case 2:
				page--;
				viewPage(size, page);
				break;
			case 3:
				break;
			}
		} while (next != 3);

	}

	void viewPage(int size, int page) throws Exception {

		System.out.println("---------------------------------------------------");

		List<TourGuide> list = dao.getPage(size * (page - 1), size * page - 1);
		for (TourGuide tg : list) {
			System.out.printf("  %s.[%s] %s : %s\n", tg.getTourId(),tg.getRegion(), tg.getName(), tg.getSite());
		}

		System.out.println("---------------------------------------------------");
	}
	// 페이지로 여행 목록 보여주기

}
