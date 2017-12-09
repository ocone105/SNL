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
		<h3>후기</h3>
		<div>
			<article>
				<h4> 후기제목 : ${review.title}</h4>
				<div>
					<p>후기날짜 : ${review.date}</p>
					<p>작성자 : ${review.writerId}</p>
				</div>
				<img
					src="C:/Users/kosta/git/Final/HanBang/WebContent/uploadFile/${review.photo}"
					alt="">
				<p>사진 : ${review.photo }</p>
				<p>** 후기내용 : ${review.content}</p>
				<a href="removeReview.do?reviewId=${review.reviewId }">후기삭제</a>
				<br>
				<a href="reportReview.do?reviewId=${review.reviewId }">!후기신고!</a>
			</article>
			<c:forEach items="${answers }" var="answer">
				<div class="request">
				<br>
					<p>** 답변내용 : ${answer.content }</p> 
					<p>${answer.writerId }</p>
					<p>${answer.date }</p>
					<a href="removeAnswer.do?answerId=${answer.answerId }&reviewId=${review.reviewId}">답변삭제</a>
				</div>
			</c:forEach>
			<form action="${ctx}/review/registAnswer.do" method="post">
				<textarea rows="20" cols="50" name="content"></textarea>
				<input type="hidden" name="reviewId" value="${review.reviewId }" />
				<input type="submit" value="등록"> <input type="button"
					value="취소">
			</form>
		</div>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>