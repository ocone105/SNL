<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">

<head>
<meta charset=utf-8">
<title>한방</title>
<%@ include file="/views/layout/common.jsp" %>
</head>

<body>

<%@ include file="/views/layout/header.jsp" %>

<main>
	<section>
		<h3>후기 수정</h3>
		<form action="${ctx}/review/modifyReview.do" method="post" enctype="multipart/form-data">
			<div>
				<h4><input type="text" name="title" placeholder="${review.title }"><input type="hidden" name="title" value="${review.title }"></h4>
				<textarea rows="30" cols="100" name="content" placeholder="후기내용">${review.content }</textarea>
				<label>사진 추가<input type="file" name="file">사진 : ${review.photo}</label>
			</div>
			<input type="submit" name="reviewCreateBtn" value="수정하기">
			<input type="hidden" name="reviewId" value="${review.reviewId }">
		</form>
	</section>
</main>

<%@ include file="/views/layout/footer.jsp" %>

</body>
</html>