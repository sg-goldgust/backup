<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script>
var temp = "test"
var str = `temp 변수 값 : \${temp}`;
console.log(str);
</script>

<body>
	${"Hello"}<br>
	<%="Hello" %><br>
	<% out.println("Hello"); %><br>
	${null}<br>
	${true}<br>
	
	\${5 mod 2} : ${5 mod 2};<br>
	${empty input }
	
</body>
</html>