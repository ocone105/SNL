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
		<button type="button" name="reportBtn">신고</button>
		<div>
			<h3>${shareHouse.Title}</h3>
			<div>
				<button type="button" name="interestShareHouseCreateBtn">
					<span class="hide">등록</span>
				</button>
				<button type="button" name="interestShareHouseDeleteBtn">
					<span class="hide">삭제</span>
				</button>
			</div>
			<span>${shareHouse.Title}</span>
			<ul>
				<c:forEach var="photo" items="${shareHouse.photos }">
					<li><img src="${photo.photo}" alt="셰어하우스 이미지"></li>
				</c:forEach>
			</ul>
			<button type="button" name="leftBtn">
				<span class="hide">이전</span>
			</button>
			<button type="button" name="rightBtn">
				<span class="hide">다음</span>
			</button>
		</div>
		<article>
			<h4>셰어하우스 정보</h4>
			<ul>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</article>
		<ul>
			<li><a href="#houseInfo">하우스 정보</a></li>
			<li><a href="#roomInfo">룸 정보</a></li>
			<li><a href="#reviewList">후기</a></li>
		</ul>
		<div>
			<article id="houseInfo">
				<h4>하우스 정보</h4>
				<ul>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</article>
			<article id="roomInfo">
				<h4>룸 정보</h4>
				<ul>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</article>
		</div>
		<div>
			<h4>후기</h4>
			<ul id="reviewList">
				<li><span>셰어하우스 제목</span> <span>작성자ID</span> <span>작성 날짜</span>
				</li>
				<c:forEach var="review" items="reviewList">
					<li><a href="${ctx}/reviewDetail.do"> <span>${review.shareHouseTitle }</span>
							<span>${review.authorId}</span> <span>${review.writeDate }</span>
					</a></li>
				</c:forEach>
			</ul>
			<!-- 후기 페이징 부분 -->
			<ul>
				<c:forEach var="pageNumber" items="paging" end="">
					<li><a href="#a">${pageNumber.pageNumber}</a></li>
				</c:forEach>
			</ul>
		</div>
	</section>
	<aside>
		<!-- 하우스 주소 가져오기 -->
		<iframe>지도</iframe>
		<a href="${ctx}/questionCreate.jsp">하우스 방문 문의</a>
	</aside>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>