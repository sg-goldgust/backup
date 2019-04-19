/**
 * 
 */
$.fn.deletePanel = function(opt) {
var self = this;
var templ = `
<form class="my-3">
비밀번호 :
<input type="password" name="password" required>
<button type="submit" class="btn btn-primary btn-sm">
<i class="fas fa-times"></i> 삭제
</button>
<button type="button" class="btn btn-primary btn-sm cancel">
<i class="fas fa-undo"></i> 취소
</button>
</form>`;

self.append(templ);
var password = self.find(':password'); }
var triger = $(opt.triger);
var url;

triger.click(function() {
	var userId = $(this).data('user-id');
	if(userId) //특정인 제거
		url = opt.url.replace('\{user-id\}',userId);
	else{
		if($(this).data('mode') == 'multiple') { //선택삭제
			//var items = $(opt.multiple);
			var items = [];
			$(opt.multiple).each(function() {
				items.push($(this).val());
			})
			
			
			
		} else { //view페이지에서 삭제
			url = opt.url;
		}
	} //개별페이지에서 온것인가 다중 선택에 의해서 온 것인가
	self.show();
})

//$(opt.triger).click(()=>self.show()); 

self.on('click', '.cancel', ()=>{ password.val(''); self.hide(); })

self.on('submit', 'form', function(e) { 
	e.preventDefault(); 
	if(!confirm("삭제할까요?")) return; // Ajax로
																							// delete
																							// 요청
	axios.delete(opt.url + '?password=' + password.val()) 
		.then(function(obj) { 
			if(obj.data.result == 'success') { location = opt.moveUrl; } 
			else { alert(obj.data.result); } }) 
		.catch(console.log);		
	});
