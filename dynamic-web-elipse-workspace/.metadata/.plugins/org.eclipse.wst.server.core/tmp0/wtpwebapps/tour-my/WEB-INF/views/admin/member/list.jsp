<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>


<script>

	$(function() {
		$('#delete-panel').deletePanel({
			triger : '.delete', // 판넬 출력 제어
			url : 'delete/{user-id}',
			//url : '../delete/${member.userId}', // 삭제 요청 url
			multiple : '[name=check-item]:checked',
			moveUrl : '../list?page=${param.page}' // 삭제 후 이동 url
		});
		
		$('#check-all').change(e){
			$('[name=check-item]').prop('checked',this.checked);
		});
	
		$('[name=check-item]').change(function(e){
			if(!this.checked) {
				$('#check-all').prop('checked',false);
			}
		})
		
		$('.check-delete').click(function(e){
			var items = $('[name=check-item]:checked');
			items.each()
		});
		
	});
</script>


<h2 class="my-5">
	<i class="fas fa-list"></i> 회원 관리 목록
</h2>




<div class="text-right">
	<a href="create"><i class="fas fa-edit"></i> 회원 정보 추가</a> (총 :
	${pi.totalCount} 건)
</div>

<table class="table table-striped table-hover">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>등급</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>등록일</th>
	</tr>

	<c:forEach var="member" items="${pi.list}" varStatus="status">
		<tr>
		
			<td>
				${pi.totalCount-((pi.page-1)*10)-status.index}
			</td>
			<td>${member.userId}</td>
			<td><a href="view/${member.userId}?page=${pi.page}">
					${member.name}</a> <iot:newToday test="${member.regDate}" /></td>

			<td>${member.userLevel}</td>
			<td>${member.email}</td>
			<td>${member.phone}</td>
			<td>${member.address}</td>
			<td><fmt:formatDate value="${member.regDate}"
					pattern="yyyy-MM-dd" /></td>
			<td class = "text-right">
			
			</td>			
		</tr>
	</c:forEach>
</table>

<iot:pagination pageInfo="${pi}" />