package edu.autocar.tourguide.service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

/**
 * <pre>
 *  
 * edu.autocar.tourguide.service 
 * TourGuideService.java
 * 2019. 1. 7.
 * </pre>
 *
 * TourGuide app의 서비스를 제공하는 역활을 한다.
 * 
 * @author student
 *
 */
public class TourGuideService {

	TourGuideDao dao = new TourGuideDaoImpl();
	final static int size = 10;

	/**
	 * 선택한 도시의 여행장소를 출력한다.
	 * 
	 * @throws Exception
	 */
	public void citySearch() throws Exception {

		List<String> region = dao.showRegion();
		printRegion(region);

		String city = Input.getString("여행지를 찾고자 하는 도시를 선택하세요 : ");
		List<TourGuide> all = dao.selectlist();
		List<TourGuide> select = selectTourWithCity(all, city);
		print2(select);

	}

	public void nameSearch() throws Exception {

		String name = Input.getString("찾고자 하는 여행장소를 입력하세요 : ");
		TourGuide tg;
		tg = dao.selectName(name);
		assert tg != null : "입력한 여행장소가 없습니다.";
		
		System.out.println("---------------------------------------------------");
		System.out.printf("[%s] %s : %s\n", tg.getRegion(), tg.getName(), tg.getSite());
		System.out.println("---------------------------------------------------");
	}

	static List selectTourWithCity(List<TourGuide> all, String city) {
		List<TourGuide> select = new ArrayList<TourGuide>();

		for (TourGuide tg : all) {
			if (tg.getCity().equals(city))
				select.add(tg);
		}

		return select;
	}

	static void print2(List<TourGuide> select) {
		System.out.println("---------------------------------------------------");
		for (TourGuide tg : select) {
			System.out.printf("[%s] %s : %s\n", tg.getRegion(), tg.getName(), tg.getSite());
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

	/**
	 * 검색하고자 하는 지역과 내용을 입력받는다. 해당 지역의 해당 내용을 포함하는 리스트를 출력한다.
	 * 
	 * @throws Exception
	 */
	public void contentSearch() throws Exception {
		String city = Input.getString("검색하고자 하는 지역을 입력하세요 : ");
		String search = Input.getString("특정 내용을 포함하고 싶은 단어를 입력하세요 : ");
		List<TourGuide> select = dao.search(city, search);
		print(select);

	}

	static void print(List<TourGuide> select) {
		System.out.println("---------------------------------------------------");
		for (TourGuide tg : select) {
			System.out.printf("%d.[%s] %s : %s\n", tg.getTourId(), tg.getRegion(), tg.getName(), tg.getSite());
		}
		System.out.println("---------------------------------------------------");
	}

	public void tourCreate() throws Exception {

		String title = Input.getString("제목을 입력하세요 : ");
		String date = Input.getString("여행일정을 입력하세요 : ");
		List<String> list = new ArrayList<>();

		String site = Input.getString("여행지 번호를 입력하세요(','로 구분지어서 표기하세요 :");
		String[] arr = site.split(",");

		for (String auto : arr) {
			list.add(auto);
		}

		String fileName = Input.getString("파일이름을 입력하세요 : ");
		String root = "C:/Temp/" + fileName + ".txt";

		fileCreate(fileName, date, list, root);
	}

	/**
	 * 여행 정보를 담은 파일을 만든다.
	 * 
	 * @param title : 여행의 제목을 입력받는다.
	 * @param date  : 여행일정을 입력받는다.
	 * @param list  : 여행목록을 입력받는다.
	 * @param root  : 파일 경로를 입력받는다
	 * @throws Exception
	 */
	static void fileCreate(String title, String date, List<String> list, String root) throws Exception {

		TourGuideDao dao = new TourGuideDaoImpl();
		// 파일 생성기
		File file = new File(root);

		try (FileWriter fw = new FileWriter(file);) {

			fw.write("제목 : " + title + "\r\n");
			fw.write("일정 : " + date + "\r\n");

			for (String key : list) {
				TourGuide tg = dao.selectOne(key);
				fw.write("여행지: " + "\r\n");
				fw.write(tg.getName() + "---------------------------------------" + "\r\n");
				fw.write(tg.getContent() + "\r\n");
				fw.write("-----------------------------------------------------" + "\r\n");
			}
			fw.flush();

			System.out.println("생성완료");
		}
	}

	/**
	 * 찾아볼 페이지를 입력받아 해당 페이지 여행정보를 출력한다. 페이지 선택 이후, 페이지 이동과 페이지네이션 종료를 선택할 수 있다.
	 * 
	 * @throws Exception
	 */
	public void pagination() throws Exception {

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

	/**
	 * 
	 * 사용자가 선택한 페이지의 여행정보를 보여준다. '번호.[도시,지역] 여행명 : 여행지'의 형태로 보여준다.
	 * 
	 * @param size 페이지네이션에서 페이지의 크기,상수로 설정하여 10을 부여하였다.
	 * @param page 페이지네이션에서 현재 페이지 번호
	 * @throws Exception
	 */
	void viewPage(int size, int page) throws Exception {

		System.out.println("---------------------------------------------------");
		List<TourGuide> list = dao.getPage(size * (page - 1), size * page - 1);
		for (TourGuide tg : list) {
			System.out.printf("%s.[%s,%s] %s : %s\n", tg.getTourId(), tg.getCity(), tg.getRegion(), tg.getName(),
					tg.getSite());
		}
		System.out.println("---------------------------------------------------");
	}
}
