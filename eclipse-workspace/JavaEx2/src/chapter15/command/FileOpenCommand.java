package chapter15.command;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;

public class FileOpenCommand implements Command {

	@Override
	public void execute() throws Exception {
		String fpath = Input.getString("파일명 : ");
		TestService service = TestService.getInstance();
		service.open(fpath);
		
		System.out.println(fpath + " 파일 읽기 완료");
		System.out.println();
	}

}
