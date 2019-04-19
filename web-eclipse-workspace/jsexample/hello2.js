/**
 * 
 */
var list = require('./tour.js')

var rlt = {};
list.forEach(function(obj){
	rlt[obj.region]=[];
}); 
console.log(rlt);

for(var key in rlt) {
	var temp =list.filter(function(object) {
		return (object.region == key) ;		
	})

	rlt[key].push(...temp);
};

console.log(rlt);

function toTr(tour) {
	return`
	<tr>
		<td>${tour.region}</td><td>${tour.city}</td><td>${tour.address}</td>
	</tr>`;
	
} //html로 바꾸는 함수를 따로 지정한다.

var trs = list.map(toTr).join('\n'); //여행 list를  map(html 변환 함수)를 통해 해결한다.
var table = '<table>\n'+trs+'\n</table>';
console.log(table)
//이를 화면에 출력하는 것을 jQuery에서 담당한다.


/*
var test = [0,1,2,3,4,5,6,7]

function shuffle(arr) {
	function swap(a,b) {
		var temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	for(var i = arr.length; 0 < i; --i){
		var random = parseInt(Math.random()*i);
		swap(i-1,random);
	}
}
shuffle(test);
console.log(test);

//배열 객체의 shuffle 이라는 속성을 대입
Array.prototype["shuffle"] = function(){  //Array.prototype.shuffle을 써도 동일하다.
	shuffle(this);
}
var test2 = [0,1,2,3,4,5,6,7]
test2.shuffle();
console.log(test2);

list.shuffle();
var test3 =list.filter(function(object) {
	return (object.region == "강원권") ;
		
})
console.log(test3.length);

*/