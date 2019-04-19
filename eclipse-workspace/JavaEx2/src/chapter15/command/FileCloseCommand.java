package chapter15.command;

import edu.autocar.base.command.Command;

public class FileCloseCommand implements Command {

	@Override
	public void execute() throws Exception {
		System.out.println("파일을 닫습니다.");
		System.out.println();
	}

}
