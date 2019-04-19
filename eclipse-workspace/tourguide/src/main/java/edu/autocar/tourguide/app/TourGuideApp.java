package edu.autocar.tourguide.app;

import edu.autocar.tourguide.command.ExitCommand;
import edu.autocar.tourguide.command.Pagination;
import edu.autocar.tourguide.command.ScheduleCommand;
import edu.autocar.tourguide.command.SelectTourWithCity;
import edu.autocar.tourguide.command.SelectTourWithContent;
import edu.autocar.tourguide.command.SelectTourWithName;
import edu.autocar.tourguide.service.TourGuideService;

/**
 * @author 이도훈
 * 
 * TourGuide 애플리케이션 클래스
 * 운영에 필요한 메뉴를 구성하고, 메뉴 명령을 실행하여 애플리케이션이 기동됨
 *
 */
public class TourGuideApp extends Application {
	//필드의 초기화는 생성자에서 해주는 것이 좋다.
	TourGuideService service; //부모생성자호출이 끝나고 들어간다.
	
	
	@Override
	protected void init() {
		service = new TourGuideService();
	}
	
	public TourGuideApp() {
		super();
		
	}
	
	protected void createMenu(MenuBar menu) {
		
		service= new TourGuideService();
		
		menu.add(new MenuItem("페이지로 보기" , "p" , service :: pagination));
		menu.add(new MenuItem("도시별로 보기" , "c" , service :: citySearch));
		menu.add(new MenuItem("내용에서 찾기" , "f" , service :: contentSearch));
		menu.add(new MenuItem("여행명으로 찾기" , "n" , service :: nameSearch));
		//menu.add(new MenuItem("여행명으로 찾기" , "n" , new SelectTourWithName()));
		menu.add(new MenuItem("종료" , "q" , ()->System.exit(0)));
		menu.add(new MenuItem("파일생성" , "s" , service :: tourCreate));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
	/**
	 * 애플리케이션 종료 메서드
	 * 
	 */
	public void exit() {
		System.out.println("종료합니다");
	}
	
	public static void main(String[] args) {
		Application app = new TourGuideApp();
		app.run();
	}
	

}
