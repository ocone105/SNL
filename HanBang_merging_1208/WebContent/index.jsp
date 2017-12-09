<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<c:set var="log" value="in" />

<!doctype html>
<html lang="ko">

<head>
<meta charset=utf-8">
<title>한방</title>
<link rel="stylesheet" type="text/css"
	href="${ctx}/resources/css/default.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/resources/css/styleMobile.css"
	media="screen and (max-width:769px)">
<link rel="stylesheet" type="text/css"
	href="${ctx}/resources/css/styleTablet.css"
	media="screen and (min-width:770px) and (max-width:1023px)">
<link rel="stylesheet" type="text/css"
	href="${ctx}/resources/css/index.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/resources/css/mobile.css"
	media="screen and (max-width:769px)">
<link rel="stylesheet" type="text/css"
	href="${ctx}/resources/css/tablet.css"
	media="screen and (min-width:770px) and (max-width:1023px)">
<script src="${ctx}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/resources/js/jquery-ui.js"></script>
<script src="${ctx}/resources/js/hanbangIndex.js"></script>
</head>

<body>

	<a href="#header" class="skip">본문바로가기</a>
	<header id="header">
		<%@ include file="/views/layout/header.jsp"%>


		<div class="searchShareHouse">
			<a href="${ctx}/shareHouse/shareHouseList.do">하우스 찾아보기</a>
			<form action="searchShareHouse.do" method="post">
				<div class="shareHouseGender">
					<label><input type="radio" name="shareHouseGender">성별
						무관</label> <label><input type="radio" name="shareHouseGender">여성
						전용</label> <label><input type="radio" name="shareHouseGender">남성
						전용</label>
				</div>
				<div class="searchBar">
					<input type="text" name="searchWord"
						placeholder="지역명, 대학교, 지하철역을 입력해 주세요."> <input
						type="submit" value="찾아보기">
				</div>
			</form>
		</div>
		
	</header>
	

	<main>
	<section>
		<h3>추천 하우스</h3>
		<p>단기간 내에 바로 입주 가능한 셰어하우스</p>
		<ul class="shareHouseRecommend clear">

			<c:forEach var="shareHouse" items="${shareHouses }">
				<li><a
					href="${ctx}/shareHouse/shareHouseDetail.do?shareHouseId=${shareHouse.shareHouseId}">
						<div>
							<div>
								<img src="/images/${shareHouse.photos[0].photo}">
							</div>
							<div>
								<h4>${shareHouse.title}</h4>
								<c:choose>
									<c:when test="${shareHouse.rooms[0].sex eq '여성 전용'}">
										<p class="woman">여성전용</p>
									</c:when>
									<c:when test="${shareHouse.rooms[0].sex eq '남성 전용'}">
										<p class="man">남성전용</p>
									</c:when>
									<c:otherwise>
										<p class="unisex">성별 무관</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div>
							<span>${shareHouse.essentialInfo.buildingType}</span>
							<c:if test="${houses ne null }">
								<c:forEach var="house" items="${houses }">
									<c:if test="${shareHouse.houseId  eq house.houseId }">
										<span>${house.rooms}</span>
										<span>${house.bathrooms}</span>
									</c:if>
								</c:forEach>
							</c:if>
							<p>${shareHouse.rooms[0].deposit }/
								${shareHouse.rooms[0].monthlyFee }</p>
						</div>
				</a></li>
			</c:forEach>
		</ul>
	</section>
	</main>

	<footer>
		<p class="copyright">ⓒ 2017. Hanbang All Rights Reserved</p>
		<address></address>
	</footer>

</body>
</html>