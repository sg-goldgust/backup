<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 class="my-5">
		<i class="fas fa-file-alt"></i> ${gallery.title}
	</h2>
	<div style="overflow: hidden">
		<div class="float-left">작성자 : ${board.writer}, 조회수 :
			${gallery.readCnt}</div>
		<div class="float-right">
			수정일 :
			<fmt:formatDate value="${gallery.updateDate}"
				pattern="yyyy-MM-dd HH:mm:ss" />
		</div>
	</div>
	<hr />
	${gallery.description}
	<hr />
	<!-- 사짂 목록 -->
	<c:forEach var="image" items="${gallery.list}" varStatus="s">
		<img src="${contextPath}/gallery/image/${image.imageId}" width="400">
		<img src="${contextPath}/gallery/thumb/${image.imageId}">
		<a href="${contextPath}/gallery/download/${image.imageId}"> <i
			class="fas fa-download"></i> 다운로드
		</a>
		<hr />
	</c:forEach>
	
	<div class = "form-group">
		<label for = "file">추가할 이미지를 입력하세요</label>
		<input type = "file" name = "files" class = "form-control-file"
			multiple = "multiple" accept = "image/*">
	</div>

	<div id="delete-panel"></div>
	<div class="text-center">
		<c:if test="${USER.userId == gallery.owner}">
			<a href="../edit/${gallery.galleryId}?page=${param.page}"
				class="btn btn-primary ok text-white"> <i class="fas fa-edit"></i>
				수정 완료
			</a>
			<button class="btn btn-danger delete">
				<i class="fas fa-trash"></i> 삭제
			</button>
		</c:if>
	</div>
</body>
</html>