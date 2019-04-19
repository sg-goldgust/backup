package edu.autocar.contact.command;

import java.io.File;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;
import edu.autocar.contact.service.ContactService;

public class OpenCommand implements Command {

	@Override
	public void execute() throws Exception {
		ContactService service = ContactService.getInstance();
		
		String fname = Input.getString("읽을 파일명 : ");
		File file = new File("c:/temp", fname);
		try {
			service.open(file);
			System.out.println("파일 열기 완료");
		} catch (Exception e) {
			System.err.println("파일 열기에 실패했습니다.");
			System.err.println(e.getMessage());
		}
	}

}
