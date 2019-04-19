/**
 * 
 */

var ar =[1,2,5,,,,9,15];

for (var i =0; i<ar.length; i++){
	console.log("ar["+i+"]="+ar[i]);
}
console.log("==============================");
ar.length = 3; //java와 다르게 length가 상수가 아니다. 나머지 값들이 undefined로 배정된다.
for (var i =0; i<ar.length; i++){
	console.log("ar["+i+"]="+ar[i]);
}
console.log("==============================");
ar.length = 10;
for (var i =0; i<ar.length; i++){
	console.log("ar["+i+"]="+ar[i]);
}
console.log("==============================");
ar[20] = 0; //사이 값들이 undefined로 배정된다.
for (var i =0; i<ar.length; i++){
	console.log("ar["+i+"]="+ar[i]);
}
console.log("==============================");
for(var i in ar) {
	console.log("ar["+i+"]="+ar[i]);
}
//실제 데이터가 있는 element에 key i 가 할당 된다.