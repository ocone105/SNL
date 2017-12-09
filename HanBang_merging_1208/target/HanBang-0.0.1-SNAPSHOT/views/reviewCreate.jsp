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
		<h3>후기 등록</h3>
		<form action="${ctx}/review/registReview.do" method="post" enctype="multipart/form-data">
			<div>
				<input type="text" name="title" placeholder="제목">
				<textarea rows="30" cols="100" name="content"></textarea>
				<label>사진 추가<input type="file" name="file"></label>
			</div>
			<input type="submit" name="reviewCreateBtn" value="등록하기">
		</form>
	</section>
</main>

<%@ include file="/views/layout/footer.jsp" %>

</body>
</html>