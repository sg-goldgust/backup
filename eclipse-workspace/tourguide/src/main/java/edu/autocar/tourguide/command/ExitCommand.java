package edu.autocar.tourguide.command;

import edu.autocar.tourguide.database.ConnectionProvider;

public class ExitCommand implements Command {

	@Override
	public void execute() throws Exception {
		System.out.println("종료");
		ConnectionProvider.getSqlSession().close();
		System.exit(0);
	}

}
