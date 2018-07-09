<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 정보</title>
</head>
<body>

	<h1>${sessionScope.member.userId}회원정보</h1>
	<hr>
	<form action="/mupdate.do" method="POST">
		아이디
		<input type="text" name="userId" value="${modelMember.userId}" readonly="readonly">
		<br>
		<br>
		비밀번호
		<input type="password" name="userPw" value="${modelMember.userPw}">
		<br>
		<br>
		이름
		<input type="text" name="userName" value="${modelMember.userName}" readonly="readonly">
		<br>
		<br>
		전화번호
		<input type="text" name="phone" value="${modelMember.phone}">
		<br>
		<br>
		<button type="submit">변경</button>
		<button type="button" onclick="back();">뒤로가기</button>
	</form>
</body>

<script type="text/javascript">
	function back() {
		window.location.href="/";
	}
</script>
</html>