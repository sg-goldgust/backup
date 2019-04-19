package sequence;

public class FiboEx2 {

	public static int fibo(int num){
		if(num== 0) return 0;
        if(num == 1) return 1;
        else return fibo(num-1) + fibo(num-2);
	}
	
	public static void main(String[] args) {
		int n = 20;
		int num = fibo(n);
		System.out.println(n + "번째 : " + num);
		
		
		
//        for(int i = 1 ; i < num ; i++ ){
//        	System.out.print(fibo(i) + " ");
//        }
	}


}
