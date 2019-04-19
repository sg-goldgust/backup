<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script
	src="${contextPath}/resources/bower_components/tinymce/tinymce.min.js"></script>
<script src="${contextPath}/resources/js/member.js"></script>
<script>
	$(function() {
		tinymce.init({
			selector : 'textarea',
		});
		//목록으로 가기 버튼
		$('.back').click(function() {
			location = '../list?page=${param.page}';
		});
	})

	$(function() {
		$('.id-check').checkUserId(); // 사용자 ID 중복 체크 플러그인
		$('#member').checkPassword(); // 비밀번호 일치 체크 플러그인
	})
</script>

<h2 class="my-5">
	<i class="fas fa-edit"></i> 회원 정보 작성
</h2>



<form:form modelAttribute="member">
	<div class="form-group id-check">
		<label for="userId">아이디를 입력하세요
			<button type="button" class="btn btn-primary btn-sm id-check">
				<i class="fas fa-user-check"></i>중복체크
			</button> <span id="message"></span>
		</label>
		<form:input path="userId" class="form-control" />
		<form:errors path="userId" element="div" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="password">비밀번호</label>
		<form:password path="password" class="form-control" />
		<form:errors path="password" element="div" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="password2">비밀번호 확인</label> <input type="password"
			id="password2" class="form-control" />
	</div>
	<div class="form-group">
		<label for="userId">이름을 입력하세요</label>
		<form:input path="name" class="form-control" />
		<form:errors path="name" element="div" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="userLevel">회원 등급을 선택하세요</label>
		<form:select path="userLevel" class="form-control">
			<form:options items="${ulList}"></form:options>
		</form:select>
	</div>
	<div class="form-group">
		<label for="title">이메일을 입력하세요</label>
		<form:input path="email" class="form-control" />
	</div>
	<div class="form-group">
		<label for="title">전화번호을 입력하세요</label>
		<form:input path="phone" class="form-control" />
	</div>
	<div class="form-group">
		<label for="title">주소를 입력하세요</label>
		<form:input path="address" class="form-control" />
	</div>
	<div class="text-center">
		<button type="submit" class="btn btn-primary ok" disabled>
			<i class="fas fa-check"></i> 완료
		</button>
		<a href="list?page=${param.page}" class="btn btn-primary back"> <i
			class="fas fa-undo"></i>목록
		</a>
	</div>
</form:form>

