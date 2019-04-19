<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class = "container">

	<div class = "text-right">
		(총 : ${pi.totalCount}건)
	</div>
	
	<table class = "table table-striped table-hover">
	<tr>
		<c:set var="today" value="<%=new java.util.Date() %>"/>
		<c:forEach var = "m" items="${pi.list}" varStatus="status">
			<tr>
				<td>${(pi.page-1)*pi.perCount+1+status.index}</td>
				<td>${m.userId}
				<c:if test = "${regDate==today}"><span class="badge badge-secondary">New</span></c:if>
				</td>
				<td>${m.name}</td>
				<td>${m.email}</td>
				<td>${m.phone}</td>
				<td>${m.regDate}</td>
			</tr>
		</c:forEach>
	</tr>
	</table>
</div>
	<ul class = "pagination justify-content-center">
		<c:forEach var="ix" begin="1" end="${pi.totalPage}">
			<c:choose>
				<c:when test= "${ix==pi.page}">
					<li class = "page-item active">
						<a class = "page-link" href="#">${ix}</a></li>
				</c:when>
				<c:otherwise>
					<li class = "page-item">
						<a class = "page-link" href="?page=${ix}">${ix}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	<%-- jsp:include page = "/common/pagination.jsp"--%> 
</body>
</html>