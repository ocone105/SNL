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
		<h3>일반 회원</h3>
		<ul>
			<li>
				<span>일반 회원 ID</span>
				<span>후기 갯수 / 신고 횟수</span>
				<span>자동 삭제 후기 횟수</span>
				<span>삭제</span>
			</li>
			<c:forEach var="user" items="userList">
				<li>
					<div>
						<span>${user.userId}</span>
						<span>${user.reviewEA} / ${user.reviewReportEA}</span>
						<span>${user.autoDeleteReviewEA}</span>
						<button type="button" name="userDeleteBtn">삭제</button>
					</div>
					<div>
						<h4>[${user.userId}]의 정보</h4>
						<ul>
							<c:forEach var="review" items="reviewList" end="">
								<li>
									<a href="${ctx}/reviewDetail.do">
										<span>${review.reviewTitle}</span>
										<span>${review.reviewReportEA}</span>
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</li>
			</c:forEach>
		</ul>
	</section>
</main>

<%@ include file="/views/layout/footer.jsp" %>

</body>
</html>