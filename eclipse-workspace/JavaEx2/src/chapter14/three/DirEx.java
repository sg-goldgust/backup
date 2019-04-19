package chapter14.three;

import java.io.File;
import java.io.FilenameFilter;

public class DirEx {

	public static void main(String[] args) {
		String path = "c:/temp";
		printDir(path);
		printDir(path, (dir, name) -> name.endsWith(".jpg"));
	}

	public static void printDir(String path) {
		// c:temp 디렉토리의 파일명을 출력하세요.
		File tempFile = new File(path);

//				String[] files = file.list(new FilenameFilter() {
//					
//					@Override
//					public boolean accept(File dir, String name) {
//						// TODO Auto-generated method stub
//						return name.endsWith(".txt");
//						//return false;
//					}
//				});

		String[] files = tempFile.list((dir, name) -> name.endsWith(".jpg"));

		for (String s : files) {

			System.out.println(s);
		}
	}

	public static void printDir(String path, FilenameFilter filter) {
		File tempFile = new File(path);

		String[] files = tempFile.list(filter);

		for (String s : files) {

			System.out.println(s);
		}
	}

//	String dir;
//	File tempFile = new File(dir);
//	FilenameFilter filter = new FilenameFilter( 
//			(dir,name)-> {return name.
//
//	String[] files = tempFile.list(filter);
//	
//
//	
//			}
}
