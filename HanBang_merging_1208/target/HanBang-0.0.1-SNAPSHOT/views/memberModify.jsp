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

<%@ include file="/views/layout/header.jsp" %>

<main>
	<section>
		<h3>회원 정보 수정</h3>
		<p>[${name }]님의 정보 입니다.</p>
		<form action="${ctx}/modifyMember.do" method="POST">
			<div>
				<label>아이디<input type="text" name="id" value="${memberId }"  readonly></label>
				<label>비밀번호<input type="password" name="password" value="${member.password }" ></label>
				<label>비밀번호 확인<input type="password" name="passwordCheck" value="${member.password }"></label>
			</div>
			<div>
				<label>이름<input type="text" name="name" value="${name }" readonly></label>
				<label>연락처<input type="tel" name="phoneNumber" value="${member.phoneNumber }" placeholder="${member.phoneNumber }"></label>
				<label>이메일<input type="email" name="email" value="${member.email }" placeholder="${member.email }"></label>
			</div>
				
			<input type="submit" name="memberModifyBtn" value="저장">
		</form>
	</section>
</main>

<%@ include file="/views/layout/footer.jsp" %>

</body>
</html>