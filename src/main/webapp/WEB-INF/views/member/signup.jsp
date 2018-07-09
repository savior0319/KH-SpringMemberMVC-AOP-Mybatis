<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>
</head>
<body>
	<fieldset>
		<legend><h1>회원가입 정보</h1></legend>

		<form action="/signup.do" method="POST" accept-charset="utf-8">
			아이디  <input type="text" name="userId" value="" placeholder="아이디 입력"><br><br>
			비밀번호 <input type="password" name="userPw" value="" placeholder="비밀번호 입력"><br><br>
			이름 <input type="text" name="userName" value="" placeholder="이름 입력"><br><br>
			전화번호 <input type="tel" name="phone" value="" placeholder="전화번호 입력"><br><br>

			<button type="submit">가입하기</button>
		</form>
	</fieldset>
</body>
</html>