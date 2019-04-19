package edu.autocar.goodsinfo.app;

import edu.autocar.base.util.Input;
import edu.autocar.goodsinfo.command.ExitCommand;
import edu.autocar.goodsinfo.command.GoodsInfoAddCommand;
import edu.autocar.goodsinfo.command.GoodsInfoDeleteCommand;
import edu.autocar.goodsinfo.command.GoodsInfoListCommand;
import edu.autocar.goodsinfo.command.GoodsInfoUpdateCommand;
import edu.autocar.goodsinfo.dao.MemberDao;
import edu.autocar.goodsinfo.domain.Member;

public class GoodsInfoApp extends Application {

	@Override
	protected void createMenu(MenuBar menu) {
		
		menu.add(new MenuItem("목록" , "l" , new GoodsInfoListCommand()));
		menu.add(new MenuItem("추가" , "a" , new GoodsInfoAddCommand()));
		menu.add(new MenuItem("수정" , "e" , new GoodsInfoUpdateCommand()));
		menu.add(new MenuItem("삭제" , "d" , new GoodsInfoDeleteCommand()));
		menu.add(new MenuItem("종료" , "q" , new ExitCommand()));
		
	}
	
	private void login() throws Exception {
		String userId = Input.getString("id : ");
		String password = Input.getString("pass : ");
		
		MemberDao dao = MemberDao.getInstance();
		Member m = dao.selectOne(userId);
		
		if (m == null) {
			throw new Exception(userId + "가 존재하지 않습니다.");
		}
		if (!password.contentEquals(m.getPassword())) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		}
		
					
	}
	
	@Override
	public void run() {
		try {
			login();
			super.run();
		} catch(Exception e) {
			System.out.println("로그인 실패");
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Application app = new GoodsInfoApp();
		app.run();
	}
	

}
