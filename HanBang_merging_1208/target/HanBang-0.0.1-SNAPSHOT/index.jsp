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
			<a href="${ctx}/shareHouse/shareHouseList.do">하우스 살펴보기</a>
			<form action="searchShareHouse.do" method="post">
				<div class="shareHouseGender">
					<label><input type="radio" name="shareHouseGender">성별
						무관</label> <label><input type="radio" name="shareHouseGender">여성
						전용</label> <label><input type="radio" name="shareHouseGender">남성
						전용</label>
				</div>
				<div class="searchBar">
					<input type="text" placeholder="지역명, 대학교, 지하철역을 입력해 주세요.">
					<input type="submit" value="찾아보기">
				</div>
			</form>
		</div>
	</header>

	<main>
	<section>
		<h3>추천 하우스</h3>
		<p>단기간 내에 바로 입주 가능한 셰어하우스</p>
		<ul class="shareHouseRecommend clear">
			<%--
          <c:forEach var="shareHouse" items="${shareHouseList}" end="">
            <li>
               <a href="${ctx}/shareHouseDetail.do">
                  <div>
                     <h4>${shareHouse.shareHouseTitle}</h4>
                     <p>${shareHouse.shareHouseGender}</p>
                     <div><img src="${ctx}/${shareHouse.shareHouseImage}" alt="셰어하우스"></div>
                  </div>
                  <div>
                     <p>${shareHouse.shareHouseAddress}</p>
                     <span>${shareHouse.shareHouseType}</span>
                     <span>${shareHouse.shareHouseRoomEA}</span>
                     <span>${shareHouse.shareHouseToiletEA}</span>
                     <p>${shareHouse.shareHouseDeposit} / ${shareHouse.shareHouseMonthlyRent}</p>
                  </div>
               </a>
            </li>
         </c:forEach>
 --%>
			<li><a href="#a">
					<div>
						<h4>셰어하우스타이틀</h4>
						<p></p>
						<div>
							<img src="" alt="셰어하우스">
						</div>
					</div>
					<div>
						<p>셰어하우스 주소</p>
						<span>셰어하우스 타입</span> <span>셰어하우스룸개수</span> <span>셰어하우스화장실개수</span>
						<p>보증금 / 월세</p>
					</div>
			</a></li>
			<li><a href="#a">
					<div>
						<h4>셰어하우스타이틀</h4>
						<p></p>
						<div>
							<img src="" alt="셰어하우스">
						</div>
					</div>
					<div>
						<p>셰어하우스 주소</p>
						<span>셰어하우스 타입</span> <span>셰어하우스룸개수</span> <span>셰어하우스화장실개수</span>
						<p>보증금 / 월세</p>
					</div>
			</a></li>
			<li><a href="#a">
					<div>
						<h4>셰어하우스타이틀</h4>
						<p></p>
						<div>
							<img src="" alt="셰어하우스">
						</div>
					</div>
					<div>
						<p>셰어하우스 주소</p>
						<span>셰어하우스 타입</span> <span>셰어하우스룸개수</span> <span>셰어하우스화장실개수</span>
						<p>보증금 / 월세</p>
					</div>
			</a></li>
			<li><a href="#a">
					<div>
						<h4>셰어하우스타이틀</h4>
						<p></p>
						<div>
							<img src="" alt="셰어하우스">
						</div>
					</div>
					<div>
						<p>셰어하우스 주소</p>
						<span>셰어하우스 타입</span> <span>셰어하우스룸개수</span> <span>셰어하우스화장실개수</span>
						<p>보증금 / 월세</p>
					</div>
			</a></li>
			<li><a href="#a">
					<div>
						<h4>셰어하우스타이틀</h4>
						<p></p>
						<div>
							<img src="" alt="셰어하우스">
						</div>
					</div>
					<div>
						<p>셰어하우스 주소</p>
						<span>셰어하우스 타입</span> <span>셰어하우스룸개수</span> <span>셰어하우스화장실개수</span>
						<p>보증금 / 월세</p>
					</div>
			</a></li>
		</ul>
	</section>
	</main>

	<footer>
		<p class="copyright">ⓒ 2017. Hanbang All Rights Reserved</p>
		<address></address>
	</footer>

</body>
</html>