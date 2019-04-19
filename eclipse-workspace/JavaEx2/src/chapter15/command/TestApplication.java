package chapter15.command;

import edu.autocar.base.Application;
import edu.autocar.base.menu.MenuBar;
import edu.autocar.base.menu.MenuItem;

public class TestApplication extends Application {
	
	@Override
	protected void createMenu(MenuBar menu) {
		menu.add(new MenuItem("Open", "o", new FileOpenCommand()));
		menu.add(new MenuItem("Close", "c", new FileCloseCommand()));
		menu.add(new MenuItem("Print", "p", new PrintCommand()));
		menu.add(new MenuItem("지역검색", "rs", new RegionSearchCommand()));
		menu.add(new MenuItem("Exit", "q", new ExitCommand()));
	}
	
	public static void main(String[] args) {
		TestApplication app = new TestApplication();
		app.run();		
	}

}
