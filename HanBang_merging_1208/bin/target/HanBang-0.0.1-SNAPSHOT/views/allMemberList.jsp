<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<title>한방</title>
<%@ include file="/views/layout/common.jsp"%>
</head>

<body>

	<%@ include file="/views/layout/header.jsp"%>

	<main>
	<section>
		<h3>전체 회원</h3>
		<h4 align="right">총 ${size } 명</h4>
		<div class="listHead">
			<span> 회원 ID</span> <span> 회원타입 </span> <span> 이름 </span>
		</div>
		<div class="detail">
			<c:set var="doneLoop" value="false" />
			<c:forEach var="member" items="${members }">

				<c:if test="${member.id  eq 'admin'}">
					<c:set var="doneLoop" value="true" />
				</c:if>

				<div>
					<ul>
						<span>${member.id}</span>
						<c:if test="${member.memberTypeId eq '1'}">
							<span> 일반회원 </span>
						</c:if>
						<c:if test="${member.memberTypeId eq '2'}">
							<span> 사업자 </span>
						</c:if>
						<span> ${member.name }</span>
					</ul>
				</div>
				<div>
					<a href="${ctx}/adminFindMember.do?memberId=${member.id}">[${member.name}]님의
						정보 바로가기</a>
				</div>
			</c:forEach>
		</div>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>