/**
 * 
 */

function byvalue(a) {
	a = 9999;
}

function byref(a) {
	a[0] = 9999;
}

var int = 1000;
var ar = [1000,2000,3000];

byvalue(int);
console.log(ar[0]);

byvalue(int); 
console.log("int = " + int + ", ar[0] = " + ar[0]);
byref(ar); 
console.log("int = " + int + ", ar[0] = " + ar[0]);