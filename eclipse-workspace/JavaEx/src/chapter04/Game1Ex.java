package chapter04;

public class Game1Ex {

	public static RSP select() {
		RSP[] rsp = RSP.values();	
		
		double value =  Math.random();
		if(value < 0.2 ) {
			return rsp[0];
		} else if((value >= 0.2) &&(value < 0.7)) {
			return rsp[1];
		}
		
		return rsp[2];		
	}
		
	public static void main(String[] args) {
		RSP com = select();
		RSP me = RSP.PAPER;
		
		System.out.println("COMPUTER : " + com);
		System.out.println("나 : " + me);
		
		Result result = judge(com, me);	// 판정
		// 결과 출력
		System.out.println("승패 : " + result);
		
	}	
	
	public static Result judge(RSP com, RSP me) {
		if(com == me) {	// 비긴 경우 
			return Result.TIE;
		} else {
			// 이기는 경우
			if( ((me == RSP.ROCK) && (com==RSP.SCISSORS)) ||	// 주먹, 가위
				((me == RSP.SCISSORS) && (com==RSP.PAPER)) ||	// 가위, 보
				((me == RSP.PAPER) && (com==RSP.ROCK)) 	// 보, 주먹
			) {
				return Result.WIN;
			} else {	// 진 경우 
				return Result.LOSE;
			}
		}
	}

}
