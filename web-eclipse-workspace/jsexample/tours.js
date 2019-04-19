var tours = require('./tour.js');
const perPage = 8;

function range(end){
	var arr = [];
	for (var i =0; i<end ; ++i) {
		arr.push(i)
	}
	return arr;
}

function random(start,end) {
	return Math.floor(Math.random()*end + start);
}

var totalPage = Math.ceil(tours.length/perPage);
var page = random(1,totalPage);
console.log(totalPage,page);

function toPageItem(e) {
	if(e == page) {
		return `<li class = "page-item active">
		<a class = "page-link" href = "#">${e}</a></li>`
	} else {
		return `<li class = "page-item">
		<a class = "page-link" href = "#">${e}</a></li>`
	}
}

function toPagination(items) {
	return `<ul class = "pagination">\n${items}\n</ul>`;
}

var items = range(totalPage)
			.map(toPageItem)
			.join('\n')
			
var pagenation = toPagination(items);
console.log(pagenation);


//html wrapping 을 일반화 하기 위해서 !!
function wrapHtml(tag,item,attrs={}) {
	var arr=[];
	
	for(var a in attrs) {
		arr.push(`${a} = "${attrs[a]}"`);
	}
	var attrstr = arr.join(' ');
	return `<${tag} ${attrstr}>\n ${item}\n</${tag}>`;
	
}

var pagination = wrapHtml('ul',items,{'class':'pagination'});
console.log(pagination);

//
function twoDigitStr(n) {
	return n<10 ? '0'+n : n;
}

//file이 mp3파일인지 정규표현식으로 검사
var fname = "";
fname.search(/\.mp3$/i);
fname.search(/\.(mp3|wav|wma|mp4)$/i);







