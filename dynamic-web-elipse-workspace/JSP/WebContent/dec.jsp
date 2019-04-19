<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int global_cnt = 0;
%>

<%
	int local_cnt = 0;
	out.print(++local_cnt);
	out.print(++global_cnt);
%>
</body>
</html>