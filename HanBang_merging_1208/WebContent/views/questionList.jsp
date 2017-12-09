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
		<ul>
			<c:forEach items="${questionList}" var="question">
				<li>
				<br>
					<div>
						<span> 연락처 : ${question.phoneNumber}</span> <span> 문의날짜 : ${question.questionDate}</span>
						<span> 작성자 : ${question.writerId}</span>
					</div>
					<div>
						<div>
							<p> 방문 가능 날짜 : ${question.schedule}</p>
							<span><a
								href="detailQuestion.do?questionId=${question.questionId }">
									문의id : ${question.questionId }</a></span>
						</div>
						
						<div>
							<article>
								<p><a href="detailQuestion.do?questionId=${question.questionId }"> * 문의내용 : ${question.questionContent}</a></p>
								<p><a href="removeQuestion.do?questionId=${question.questionId }">문의삭제</a></p>
							</article>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>