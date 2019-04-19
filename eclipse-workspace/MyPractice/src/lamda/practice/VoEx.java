package lamda.practice;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class VoEx {
	public static void main(String[] args) {
		String path="c:/temp";
		File dir = new File(path);
		
//		String[] files = dir.list(new FilenameFilter() {
//			
//			@Override
//			public boolean accept(File dir, String name) {
//				// TODO Auto-generated method stub
//				return name.endsWith(".txt");
//			}
//		});
		
		String[] files = dir.list((file,name)->name.endsWith(".txt"));
		
		for (String file : files) {
			System.out.println(file);
		}
		
		List<Vo> list = Arrays.asList(
				new Vo("이도훈"),
				new Vo("이시언")
		);
	}

}
