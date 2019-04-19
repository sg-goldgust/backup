package chapter18;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

public class FileExample{
	public static void main(String[] args) throws Exception{
		File temp = new File("c:/temp");
		
//		File[] contents = temp.listFiles(new FilenameFilter() {
//			@Override
//			public boolean accept(File dir, String name) {
//				name = name.toLowerCase();
//				return name.endsWith(".jpg");
//			}
//		});
		
		File[] contents = temp.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.length() < 1024;
			}
		});

		
		Arrays.sort(contents, new Comparator<File>() {
			@Override
			public int compare(File f1, File f2) {
				// 1. 유형이 다른 경우 디렉토리가 앞서도록 결정
				if(!(f1.isFile() == f2.isFile())) {
					return f1.isDirectory() ? -1 : 1;  
				}			
				
				// 2. 같은 유형인 경우 이름으로 결정 				
				return f1.compareTo(f2);
			}
		});
			
		for(File f : contents) {
			System.out.println(f.getName());
		}
	}
}
