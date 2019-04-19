package chapter15;

import java.util.List;
import java.util.Scanner;

public class PaginationEx {

	public static void main(String[] args) {
		List<Member> list = Member.getTestList();
		Pagination<Member> pagination = new Pagination<>(list);
		Scanner scanner = new Scanner(System.in);
		
		int page = 1;
		int totalPage = pagination.getTotalPage();
		while(true) {
			List<Member> pageList = pagination.getPage(page);			
			printList(page, pageList);
			
			System.out.println("n: 다음 페이지, p: 이전 페이지, q : 종료");
			System.out.print("선택 : ");
			String sel = scanner.nextLine().toLowerCase();
			switch(sel) {
			case "p" :  
				page = page == 1 ? 1 : --page; 
				break;
			case "n" :  
				page = page == totalPage ? totalPage : ++page; 
				break;
			case "q" : System.exit(0); break;
			}
		}
	}
	
	public static void printList(int page, List<Member> list) {
		int index = (page-1)*10+1;
		System.out.printf("\n[%d 페이지]\n", page);
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
