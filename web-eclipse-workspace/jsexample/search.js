/**
 * 
 */

var s = "독도는 일본땅 대마도는 일본땅";
console.log("s = "+s);
console.log("search ="+s.search("일.땅"))
console.log("replace =" +s.replace("일본","한국"))

var s = "0123456789";
console.log("substring = " +s.substring(3,6));
console.log("substr = "+s.substr(3,6));
console.log("slice = "+s.slice(3,6));
console.log("slice = "+s.slice(3,-2));

var music1 = "사랑과 우정 사이.mp3";
var music2 = "오직 하나뿐인 그대.mp3";

console.log("음악1 = "+music1.slice(0,-4));
console.log("음악2 = "+music2.slice(0,-4));

var citys = "서울,,부산,대전,광주";
var parts = citys.split(",");
for(var city in parts) {
	console.log("도시명 : "+parts[city]);
}

var params = {};
var query = "?name=홍길동&age=23";
var modify = query.substring(1);
var attribute = modify.split("&");
for(var element in attribute) {
	param = e.split("=");
	params[param[0]] = param[1];
}





