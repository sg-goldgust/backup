package test;

public class SampleVOTest {
	public static void main(String[] args) {
		SampleVO vo = new SampleVO("test1", "test2", 
								"test3", "test4");
		
		SampleVO vo2 = new SampleVO("test1", "test22", 
									"test32", "test5");	
		System.out.println(vo);
		System.out.println(vo.hashCode());
		System.out.println(vo.equals(vo2));
		System.out.println(vo2.hashCode());
	}
}
