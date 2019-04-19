package chapter15.command;

import chapter15.Member;
import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;

public class RegionSearchCommand implements Command {

	@Override
	public void execute() throws Exception {
		TestService service = TestService.getInstance();		
		String[] regions = service.getRegions();
		
		int sel = Input.selectList(regions);
		String region = regions[sel];
		// List<Member> list = service.getMemberList(region);
		// printList(region, list);
		Member[] members = service.getMemberList(region);
		printList(region, members);
	}
	
	public void printList(String region, Member[] arr) {
		int index = 1;
		System.out.printf("[%s] 총 %d명\n", region, arr.length);
		System.out.println("============================================");
		System.out.println("No 이름             나이");
		System.out.println("============================================");
		for(Member m : arr) {
			System.out.printf("%-3d%-10s%-10d\n", index++, m.getUserId(), m.getAge());
		}
		System.out.println("============================================");
		System.out.println();
	}
	
}
