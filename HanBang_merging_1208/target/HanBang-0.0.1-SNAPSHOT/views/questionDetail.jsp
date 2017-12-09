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
		<h3>문의</h3>
		<div>
			<article>
				<div>
					<p>연락처 : ${question.phoneNumber}</p>
					<p>문의날짜 : ${question.questionDate}</p>
					<p>작성자 : ${question.writerId}</p>
					<p>방문 가능 날짜 : ${question.schedule}</p>
					<span>문의id : ${question.questionId }</span>
					<p>** 문의내용 : ${question.questionContent}</p>
					<p>
						<a href="removeQuestion.do?questionId=${question.questionId }">문의삭제</a>
					</p>
				</div>
			</article>
			<c:forEach items="${answers }" var="answer">
				<div class="request">
					<br>
					<p>** 답변내용 : ${answer.content }</p>
					<p>${answer.writerId }</p>
					<p>${answer.date }</p>
					<a
						href="removeAnswer.do?answerId=${answer.answerId }&questionId=${question.questionId}">
						답변삭제</a>
				</div>
			</c:forEach>
			<form action="${ctx}/question/registAnswer.do" method="post">
				<textarea rows="20" cols="50" name="content"></textarea>
				<input type="hidden" name="questionId"
					value="${question.questionId}" /> <input type="submit" value="등록">
				<input type="button" value="취소">
			</form>
		</div>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>