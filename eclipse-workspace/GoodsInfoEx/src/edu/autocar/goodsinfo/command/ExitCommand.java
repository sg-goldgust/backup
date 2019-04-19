package edu.autocar.goodsinfo.command;

import edu.autocar.base.database.ConnectionProvider;

public class ExitCommand implements Command {

	@Override
	public void execute() throws Exception {
		System.out.println("종로");
		ConnectionProvider.close();
		System.exit(0);
	}

}
