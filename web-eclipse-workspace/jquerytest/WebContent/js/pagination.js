/**
 * 
 */
$.fn.pagination = function(opt) {
		opt = $.extend({
			total :0,
			active : 1,
			size: '',
			align : ''
		},opt); //상속처리를 통해 디폴트 opt설정이 가능하다.
	
		$('<ul class = "pagination">').appendTo(this);
		for (var i=1; i<=opt.total; ++i) {
			var temp = $(`<li class= "page-item"><a class="page-link" href = "?page=${i}">${i}</a></li>`);
			temp.appendTo(this);
		}
		return this;
	};