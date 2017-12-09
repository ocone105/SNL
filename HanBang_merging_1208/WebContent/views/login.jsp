<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<title>한방</title>
<%@ include file="/views/layout/common.jsp" %>
</head>

<body>

<a href="#header" class="skip">본문바로가기</a>

<header id="header" class="loginHeader">
	<h1><a href="${ctx}/index.do">한방</a></h1>
	<nav>
		<h2 class="hide">회원 메뉴</h2>
		<ul>
			<li><a href="${ctx}/views/memberJoin.jsp">회원 가입</a></li>
		</ul>
	</nav>
</header>

<main>
	<section class="loginSection">
		<h3>로그인</h3>
		<p>한방에 오신 것을 환영합니다.</p>
		<form action="${ctx}/login.do" method="post">
			<input type="text" name="memberId" placeholder="아이디">
			<input type="password" name="password" placeholder="비밀번호">
			<input type="submit" name="loginBtn" value="로그인" class="nextBtn">
		</form>
	</section>
</main>

<%@ include file="/views/layout/footer.jsp" %>

</body>
</html>