/**
 * 
 */

/*var data = [1,2,3,4,5,6];
var newData = [];

forEach(data, (e,i,arr)=>newData[i]=e*e);
forEach(data, console.log);
*/
//함수를 리턴하는 함수
function outer() {
	return function() {
	console.log('Hello Function...!');
	};
	}
	// 호출 1
	outer()();
	// 호출 2
	var fn = outer();
	fn();
	
//
function test(name) {
	var output = 'Hello' + name + '...!';
	return function() {
		console.log(output)
	}
}
test('Javascript')();