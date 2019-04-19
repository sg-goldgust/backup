package chapter11;

public class StringSubstringExample {
	public static void main(String[] args) {
		
		
		String str = "c:/temp/test/a.txt";
		
		// 디렉토리명 출력
		// 파일명 출력
		// 확장명을 제외한 순수 파일명 출력
		// 파일의 확장명 출력
		int loc = str.lastIndexOf("/");
		String dir = str.substring(0, loc);
		String fileFullName = str.substring(loc+1);
		System.out.println(dir);
		System.out.println(fileFullName);
		
		int loc2 = fileFullName.lastIndexOf('.');
		String fileName = fileFullName.substring(0, loc2);
		String extName = fileFullName.substring(loc2+1);
		System.out.println(fileName);
		System.out.println(extName);
		
	}

}
