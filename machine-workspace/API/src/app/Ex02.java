package app;

import domain.ImageItem;
import domain.SearchResult;

public class Ex02 {
	final static int MAXIMUM = 1000;
	public static void main(String[] args) {
		try {
			NaverImageApi api = new NaverImageApi();
			for(int start=1; start<MAXIMUM;) {
				System.out.println(start);
				SearchResult<ImageItem> res = api.get("�ڵ���",start);
				
				start += res.getDisplay();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
