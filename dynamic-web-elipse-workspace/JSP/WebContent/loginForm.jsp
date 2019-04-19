<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String error = (String)request.getAttribute("error");
if(error == null) error = "";

String reason = (String)request.getAttribute("reason");
if(reason == null) reason = "";

String target = (String)request.getAttribute("target");
if(target == null) target = "";
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" action="index.jsp">
		<input type = "hidden" name ="target" value = "${target}">
		<label for = "userId">아이디 :</label>
		<input type = "text" name = "id" id= "userid" value = "${param.id}"></br>
		<label for ="userpwd">암 &nbsp; 호 : </label>
		<input type = "password" name="pwd" id="userpwd"></br>
		<input type = "submit" value = "로그인"> 
	</form>
	
	<div class = "error">${error}</div>
	<div class = "reason">${reason}</div>
	
	전에 입력한 값<br>
	ID : ${param.id}, ${param["id"]}<br>
	비밀번호 : ${param.pwd}, ${param["pwd"]}<br>
</body>
</html>