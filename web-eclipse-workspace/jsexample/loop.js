/**
 * 
 */

var ar = [[0,1,2,3],[4,5]]

for(var i in ar) {
	for(var j in ar[i]) {
		console.log(`ar[${i}][${j}] = ${ar[i][j]}`)
	}
}