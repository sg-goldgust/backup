<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method = "post">
	샤용자 ID : <input type = "text" name="userId" value = "${member.userId }" required><br>
	비밀번호 : <input type = "text" name="userId" required><br>
	이름 : <input type = "text" name="userId" required><br>
	이메일 : <input type = "text" name="userId" required><br>
	전화번호 : <input type = "text" name="userId" required><br>
	성별 :
		<label>
			<input type="radio" name = "gender" value = "M"> 남
		</label>
		<label>
			<input type="radio" name = "gender" value = "F"> 여
		</label>
		<br>
		
	<input type = "submit" value = "가입하기"/>
</form>

</body>
</html>