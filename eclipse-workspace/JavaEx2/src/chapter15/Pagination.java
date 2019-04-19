package chapter15;

import java.util.ArrayList;
import java.util.List;

public class Pagination<T> {
	private List<T> list;
	private int totalPage;
	
	public Pagination(List<T> list) {
		super();
		this.list = list;
		totalPage = (int)Math.ceil(list.size()/10.);
	}
	
	public List<T> getPage(int page) {
		List<T> pageList = new ArrayList<>();
		int start = (page-1)*10;	// 시작 인덱스
		// 끝 인덱스(포함되지 않음)
		int end = (page<totalPage) ? start + 10 : list.size();		

		for(int i=start; i < end ; i++) {
			pageList.add(list.get(i));
		}
		
		return pageList;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
	
	
	
}
