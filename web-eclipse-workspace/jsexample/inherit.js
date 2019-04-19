/**
 * 
 */
var ar = [0, 1, 2, 3];
console.log("ar = " + ar);
ar.reverse();
console.log("ar = " + ar);

var ar = [0, 1, 2, 3,6,5,4];
console.log("ar = " + ar.join());

ar.sort();
console.log(ar);


var country = ["korea" , "USA"];
country.sort();
console.log(country);



ar.forEach(function(value,i,arr) {
	console.log(value,i,arr);
})

ar.map(function(value){
	return value*2;
})

console.log(ar);

var names = ['a','b','c'];
var html = names.map(function(val){
	return "<li>"+val+"</li>"
})
console.log(html);

var str = html.join("");
console.log(str);
console.log(html);


