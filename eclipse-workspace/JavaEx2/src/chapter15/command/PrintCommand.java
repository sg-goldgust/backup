package chapter15.command;

import java.util.List;

import chapter15.Member;
import edu.autocar.base.command.Command;

public class PrintCommand implements Command {

	@Override
	public void execute() throws Exception {
		TestService service = TestService.getInstance();
		List<Member> list = service.getList();
		printList(list);
	}
	
	public void printList(List<Member> list) {
		int index = 1;
		System.out.println("============================================");
		System.out.println("No 이름             나이");
		System.out.println("============================================");
		for(Member m : list) {
			System.out.printf("%-3d%-10s%-10d\n", index++, m.getUserId(), m.getAge());
		}
		System.out.println("============================================");
		System.out.println();
	}
	
	
}
