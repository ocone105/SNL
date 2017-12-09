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
		<h3>후기 등록</h3>
		<form action="${ctx}/reviewCreate.do" method="post">
			<div>
				<input type="text" name="reviewTitle" placeholder="제목">
				<textarea rows="30" cols="100"></textarea>
				<label><input type="file" name="uploadPhoto">사진 추가</label>
			</div>
			<input type="submit" name="reviewCreateBtn" value="등록하기">
		</form>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>