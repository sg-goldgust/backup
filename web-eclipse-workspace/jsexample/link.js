/**
 * 
 */
var links = {
		'네이버' : 'https://www.naver.com',
		'다음' : 'https://www.daum.net',
}
var str = "네이버와 다음은 한국의 대표적인 포털사이트입니다.";
console.log(str);

var result = str.replace(/(네이버|다음)/g,function(site) {
	return site.link(links[site]);
	//새창을 띄우게 하기 위해서
	//return `<a href = "${links[site]}" target="_blank">${site}</a>`;
});

console.log(result);

//네이버 다음이 아닌 패턴을 동적으로 만들기 위해서 literal이 아닌 new로 객체를 생성하여야 한다.
var filter = Object.keys(links).join('|');

var reg = new RegExp(filter,"g");
var result = str.replace(reg,function(site) {
	return site.link(links[site]);
});