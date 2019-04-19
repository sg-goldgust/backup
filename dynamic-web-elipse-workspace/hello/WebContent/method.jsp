<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요</h1>
	<form method = "get" action = "MethodServlet">
		<input type = "submit" value = "get방식으로 호출하기">
		<input type = "text" name = "id">
		<input type = "text" name = "age">
	</form>
	<br>
	<br>
	<form method = "post" action = "MethodServlet">
		<input type = "submit" value = "post방식으로 호출하기">
		<input type = "text" name = "id">
		<input type = "text" name = "age">
	</form>
</body>
</html>