<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset=utf-8">
<title>한방</title>
<%@ include file="/views/layout/common.jsp"%>
</head>

<body>

	<%@ include file="/views/layout/header.jsp"%>

	<main>
	<section>
		<h3>문의 내역</h3>
		<c:if test="${memberType eq '2' }">
			<ul>
				<c:forEach items="${questionList}" var="question">
					<div class="listHead">
						<span>작성자</span> <span>연락처</span> <span>문의 날짜</span>
					</div>
					<ul class="questionList">
						<li><a
							href="detailQuestion.do?questionId=${question.questionId }">
								<span>${question.writerId}</span> <span>${question.phoneNumber}</span>
								<span>${question.questionDate}</span>
						</a></li>
					</ul>
				</c:forEach>
			</ul>
		</c:if>

		<c:if test="${memberType eq '1'}">
			<c:forEach items="${questionList}" var="question">
				<div class="listHead">
					<span>문의 날짜</span> <span>문의 내용</span> <span></span> <span></span>
				</div>
				<ul class="questionList">
					<li><a
						href="detailQuestion.do?questionId=${question.questionId }"> <span>${question.questionDate}</span>
							<span>${question.questionContent}</span> <span> <a
								href="${ctx }/review/registReview.do?shareHouseId=${question.shareHouseId }"><button
										type="button" class="reviewWriteBtn">후기작성</button></a>
						</span>
					</a></li>
				</ul>
			</c:forEach>
		</c:if>

	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>