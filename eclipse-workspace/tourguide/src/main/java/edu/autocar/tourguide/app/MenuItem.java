package edu.autocar.tourguide.app;

import edu.autocar.tourguide.command.Command;

public class MenuItem {
	private String title;
	private String hotKey;
	private Command command;	
	
	public MenuItem(String title, String hotKey, Command command) {
		super();
		this.title = title;
		this.hotKey = hotKey;
		this.command = command;
	}

	public String getTitle() {
		return title;
	}

	public String getHotKey() {
		return hotKey;
	}
	
	public void execute() throws Exception{
		if(command!=null) {
			command.execute();
		}
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", title, hotKey);
	}	
}
