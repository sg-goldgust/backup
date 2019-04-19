package sequence;

public class FiboEx1 {

	public static void main(String[] args) {
	      
        int a1 = 1;
        int a2 = 1;
        int a3 = 0;
        
        // System.out.println(a1);
        // System.out.println(a2);
        
        int n = 20;
        for(int i=3; i<=n; i++){
            a3=a1+a2;
            // System.out.println(a3);
            a1=a2;
            a2=a3;
        }  
        
        System.out.println(n + "번째 : " + a3);
    }


}
