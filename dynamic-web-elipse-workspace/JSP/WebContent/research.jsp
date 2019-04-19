<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>설문 조사 결과</h2>
 <% 
 	String name =request.getParameter("name");
 	out.println("이름 : <b>" + name + "</b><br>");
 	
 	String seasons[] = request.getParameterValues("season");
 	for(String e : seasons) {
 		out.println(e);
 	}
 	
 %>
</body>
</html>