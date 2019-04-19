/**
 * 
 */

var ar = [1234, "문자열", true, { name:"김상형", age:29 }]; 
for (var i = 0; i < ar.length; i++) {
	console.log("ar[" + i + "] =" + ar[i]);
	}

var ar2 = [0,1,2,3];
delete ar[2];

for(var i=0; i<ar2.length; i++){
	console.log("ar[" + i + "] =" + ar[i]);
}

