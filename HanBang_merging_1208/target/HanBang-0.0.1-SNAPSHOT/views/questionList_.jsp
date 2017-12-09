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
		<h3>문의 내역</h3>
		<ul>
			<c:if test="${memberType eq 'provider'}">
				<li><span>셰어하우스 제목</span> <span>문의 날짜</span> <span>작성자</span></li>
				<c:forEach var="question" items="questionList">
					<li>
						<div>
							<span>${question.questionTitle}</span> <span>${question.questionDate}</span>
							<span>${question.questionRedactor}</span>
						</div>
						<div>
							<div>
								<p>연락처 : ${question.questionRedactorPhoneNumber}</p>
								<p>방문 가능 날짜 : ${question.questionVisitDate}</p>
							</div>
							<div>
								<article>
									<p>${question.questionContent}</p>
									<p>${question.questionDate}</p>
									<span>${question.questionRedactor}</span>
								</article>
								<c:forEach var="questionAndAnswer" items="questionAndAnswerList">
									<c:if test="${memberType eq 'provider'}">
										<div class="response">
											<p>${questionAndAnswer.questionAndAnswerContent}</p>
											<p>${questionAndAnswer.questionAndAnswerDate}</p>
											<span>${questionAndAnswer.questionAndAnswerRedactor}</span>
										</div>
									</c:if>
									<c:if test="${memberType eq 'user'}">
										<div class="request">
											<p>${questionAndAnswer.questionAndAnswerContent}</p>
											<p>${questionAndAnswer.questionAndAnswerDate}</p>
											<span>${questionAndAnswer.questionAndAnswerRedactor}</span>
										</div>
									</c:if>
								</c:forEach>
								<form action="${ctx}/questionAndAnswerCreate.do" method="post">
									<textarea rows="20" cols="50"></textarea>
									<input type="submit" value="등록"> <input type="button"
										value="취소">
								</form>
							</div>
						</div>
					</li>
				</c:forEach>
			</c:if>
			<c:if test="${memberType eq 'user'}">
				<li><span>셰어하우스 제목</span> <span>문의 날짜</span> <span>후기</span></li>
				<c:forEach var="question" items="questionList">
					<li>
						<div>
							<span>${question.questionTitle}</span> <span>${question.questionDate}</span>
							<a href="${ctx}reviewCreate.jsp">후기 등록</a>
						</div>
						<div>
							<div>
								<h4>문의 정보</h4>
								<p>연락처 : ${question.questionRedactorPhoneNumber}</p>
								<p>방문 가능 날짜 : ${question.questionVisitDate}</p>
							</div>
							<div>
								<article>
									<p>${question.questionContent}</p>
									<p>${question.questionDate}</p>
									<span>${question.questionRedactor}</span>
								</article>
								<c:forEach var="questionAndAnswer" items="questionAndAnswerList">
									<c:if test="${memberType eq 'provider'}">
										<div class="response">
											<p>${questionAndAnswer.questionAndAnswerContent}</p>
											<p>${questionAndAnswer.questionAndAnswerDate}</p>
											<span>${questionAndAnswer.questionAndAnswerRedactor}</span>
										</div>
									</c:if>
									<c:if test="${memberType eq 'user'}">
										<div class="request">
											<p>${questionAndAnswer.questionAndAnswerContent}</p>
											<p>${questionAndAnswer.questionAndAnswerDate}</p>
											<span>${questionAndAnswer.questionAndAnswerRedactor}</span>
										</div>
									</c:if>
								</c:forEach>
								<form action="${ctx}/questionAndAnswerCreate.do" method="post">
									<textarea rows="20" cols="50"></textarea>
									<input type="submit" value="등록"> <input type="button"
										value="취소">
								</form>
							</div>
						</div>
					</li>
				</c:forEach>
			</c:if>
		</ul>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>