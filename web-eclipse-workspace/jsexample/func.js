/**
 * 
 */


function forEach(arr1, fn1) {
	if(!fn1) return; //false인경우 for roop를 돌지 않는다.
	
	for(var i=0; i<arr1.length;i++) {
		fn1(arr[i],i,arr1); //JavaScript에서는 매개변수 갯수를 check하지 않는다.
	}
}

var data = [1,2,3,4,5,6];
var newData = [];

forEach(data, (e,i,arr)=>newData[i]=e*e); //javascript에서의 람다식 표기.
forEach(data, console.log);
