/**
 * 
 */
//ES6 버전의  디폴트 값 배정
function sum(n=100) {
	if (n == undefined) 
		n = 100; // n = n || 100; 
	var s = 0; 
	for (var i = 0; i <= n; i++) { 
		s += i; 
	} 
	return s; 
}


function sumAll() {
	var sum = 0;
	for(var i=0; i<arguments.length; i++) {
		sum += arguments[i];
	}
	return sum;
}

console.log(sumAll(1,2,3,4,5,6,7,8,9))

//javascript의 내부 함수 호출
function outer() { 
	var outvalue = 5678; 
	function inner() { 
		var invalue = 1234; 
		console.log("outvalue = " + outvalue); 
	} 
	inner(); 
	console.log("invalue = " + invalue);// 에러
} 

outer();



