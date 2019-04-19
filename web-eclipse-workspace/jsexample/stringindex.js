/**
 * 
 */

var ar = [0,1,2,3];
//delete ar[1];
console.log("ar[1] =" + ar[1]);

ar["korea"]=4;
console.log('ar["korea"]=' + ar["korea"], ar.length);
console.log('ar["korea"]=' + ar.korea, ar.length);

//ar.length로 for roop 순회시 4번돌지만, for in 으로 순회시 5번 돈다.
for(var i in ar) {
	console.log("ar["+i+"]="+ar[i]);
}


ar[-3.14] = 5;
console.log("ar[-3.14] =" + ar[-3.14], ar.length);