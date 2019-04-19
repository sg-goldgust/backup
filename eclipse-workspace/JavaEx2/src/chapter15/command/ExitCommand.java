package chapter15.command;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;

public class ExitCommand implements Command {

	@Override
	public void execute() throws Exception {
		String answer = Input.getString("정말 종료할까요(Y/n)?");
		if(answer.equalsIgnoreCase("y")) {
			System.out.println("종료합니다.");
			System.exit(0);
		}
	}
}
