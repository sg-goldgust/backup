<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = "pinksung";
	String pwd = "1234";
	String name = "이도훈";
	if(id.equals(request.getParameter("id")) &&
			pwd.equals(request.getParameter("pwd")) ) {
		response.sendRedirect("main.jsp?name="+URLEncoder.encode(name,"UTF-8"));
	} else {
		response.sendRedirect("loginform.jsp");
	}
	%>
</body>
</html>