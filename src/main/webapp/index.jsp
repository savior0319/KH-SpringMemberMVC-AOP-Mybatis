<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>SpringMemberMVC 메인 페이지</title>
</head>
<body>
	<fieldset style="margin: 0 auto; display: table; width: 500px;">
		<legend><h1>로그인</h1></legend>
		<c:choose>
		<c:when test="${sessionScope.member != null}">
		<h1>[${sessionScope.member.userName}] 님 환영합니다</h1>
		<a href="/logout.do">로그아웃</a>
		<br>
		<a href="/myinfo.do">회원정보 보기</a>
		<br>
		<a href="/withdraw.do">회원탈퇴</a>
		<br>
		<c:if test="${sessionScope.member.userId == 'admin'}">
		<a href="/allmember.do">전체회원 조회</a>
		</c:if>
	<br>
</c:when>
<c:otherwise>
<hr>
<form action="/login.do" method="POST" accept-charset="utf-8">
	아이디
	<input type="text" name="userId" placeholder="아이디 입력">
	<br>
	비밀번호
	<input type="password" name="userPw" placeholder="비밀번호 입력">
	<br>
	<br>
	<button type="submit">로그인</button>
	<button type="button" onclick="signup();">회원가입</button>
</form>
</c:otherwise>
</c:choose>
</fieldset>
</body>

<script type="text/javascript">
	
	function signup(){
		location.href="/signupredirect.do"
	}

</script>
</html>