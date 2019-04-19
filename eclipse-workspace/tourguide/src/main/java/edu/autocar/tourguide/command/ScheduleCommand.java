package edu.autocar.tourguide.command;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import edu.autocar.base.util.Input;
import edu.autocar.tourguide.dao.TourGuideDao;
import edu.autocar.tourguide.dao.TourGuideDaoImpl;
import edu.autocar.tourguide.domain.TourGuide;

public class ScheduleCommand implements Command {

	public static void main(String[] args) throws Exception {

		TourGuideDao dao = new TourGuideDaoImpl();
		String title = Input.getString("제목을 입력하세요 : ");
		String date = Input.getString("여행일정을 입력하세요 : ");
		List<String> list = new ArrayList<>();

		String site;
		do {
			site = Input.getString("여행지 번호를 입력하세요 :");
			list.add(site);
		} while (site != "\r\n");

		String fileName = Input.getString("파일이름을 입력하세요 : ");
		String root = "".format("C:/Temp/%s.txt", fileName); //path라는 이름이 좋다

		fileCreate(fileName, date, list, root);
	}

	TourGuideDao dao = new TourGuideDaoImpl();

	@Override
	public void execute() throws Exception {

		String title = Input.getString("제목을 입력하세요 : ");
		String date = Input.getString("여행일정을 입력하세요 : ");
		List<String> list = new ArrayList<>();

		String site;
		do {
			site = Input.getString("여행지 번호를 입력하세요 :");
			list.add(site);
		} while (site == "");
		
		String fileName = Input.getString("파일이름을 입력하세요 : ");
		String root = "C:/Temp/"+fileName+".txt";

		fileCreate(fileName, date, list, root);
	}

	static void fileCreate(String title, String date, List<String> list, String root) throws Exception {

		TourGuideDao dao = new TourGuideDaoImpl();
		// 파일 생성기
		File file = new File(root);
		
		
		try (FileWriter fw = new FileWriter(file);) {

			fw.write("제목 : " + title + "\r\n");
			fw.write("일정 : " + date + "\r\n");

			for (String key : list) {
				TourGuide tg = dao.selectOne(key);
				fw.write("여행지: " + "\r\n" );
				fw.write(tg.getName() + "---------------------------------------" + "\r\n");
				fw.write(tg.getContent()+ "\r\n");
				fw.write("-----------------------------------------------------" + "\r\n");
			}
			fw.flush();

			System.out.println("생성완료");
			
//			StringTokenizer stk = new StringTokenizer(arg0);
//			stk.nexttoken;
//			
//			"".split(",");
		}

	}

}
