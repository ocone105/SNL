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
		<h3>일반 회원</h3>
		<div class="listHead">
			<span>일반 회원 ID</span> <span> 후기 갯수 / 신고 횟수</span> <span> </span>
		</div>
		<div class="detail">
			<c:forEach var="user" items="${members }">
				<div>
					<div>
						<span>${user.id}</span> <span> </span> <span> </span>
					</div>
				</div>
				<div>
					<div>
						<h4>[${user.id}]님의 후기</h4>
						<ul>
							<c:forEach var="review" items="${reviews }">
								<li><a
									href="${ctx}/review/detailReview.do?reviewId=${review.reviewId }">
										<span>${review.title}</span> <span>${review.date}</span>
								</a></li>

							</c:forEach>

						</ul>
						<button type="button" name="userDeleteBtn">삭제</button>
						<a href="${ctx}/adminFindMember.do?memberId=${user.id}">[${user.id}]님의
							정보 더보기</a> <a href="${ctx }/removeMember.do?memberId=${user.id }">
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>