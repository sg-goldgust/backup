/**
 * 
 */

function outcount() {
	var count = 0; //closure 변수
	
	setInterval(function() {
		count ++ ;
		console.log(count + "초 지났습니다.");
	},1000); //setInterval(callback함수, 시간간격) 인 비동기함수
}
outcount();
//io 작업은 비동기함수(노드)로 처리한다.

console.log("5! = " + function(n){
	if(n == 1){
		return 1;
	} else {
		return n * arguments.callee(n-1); //argument의 callee필드를 통해 익명함수에서 자기 자신을 호출하는 것이 가능하다.
	}
}(5)); // 익명 함수 정의하고 바로 호출