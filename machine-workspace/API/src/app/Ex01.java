package app;

import domain.ImageItem;
import domain.SearchResult;
import service.FileUtil;

public class Ex01 {
	public static void main(String[] args) {
		try {
			NaverImageApi api = new NaverImageApi();
			SearchResult<ImageItem> res = api.get("ÀÚµ¿Â÷");
			
			for(ImageItem image : res.getItems()) {
				FileUtil.download(image.getLink());  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
