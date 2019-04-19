package chapter03;

public class IPConverter {

	public static void main(String[] args) {
		if(args.length != 4) {
			System.out.println("ip숫자 4개를 입력하세요");
			System.exit(0);
		}
		
		int [] ipNums = new int[args.length];
		for (int i = 0; i < ipNums.length; i++) {
			ipNums[i] = Integer.parseInt(args[i]);
		}
				
		int ip =  ipNums[0] << 24 |		// 첫 번째 바이트
				ipNums[1] << 16 |		// 두 번째 바이트
				ipNums[2] << 8 |		// 세 번째 바이트
				ipNums[3];				// 네 번째 바이트 
		
		System.out.println(ip);		
		System.out.println(Binary.toBinaryString(ip));
		
		int ip1 = (ip & 0xFF000000)>>24;
		int ip2 = (ip & 0x00FF0000)>>16;
		int ip3 = (ip & 0x0000FF00)>>8;
		int ip4 = (ip & 0x000000FF);
		System.out.println("IP : " + 
				ip1 + "." + ip2 + "." + ip3 + "." + ip4);
	}

}
