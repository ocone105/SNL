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

	<main class="shareHouseDetail">
	<div class="device">
		<a class="arrow_left" href="#"></a> <a class="arrow_right" href="#"></a>
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<c:forEach var="photo" items="${photoList }">
					<div class="swiper-slide">
						<img src="/images/${photo.photo }" alt="셰어하우스 이미지">
					</div>
				</c:forEach>
			</div>
			<div class="pagination"></div>
			<button type="button" name="reportBtn" class="reportBtn">신고</button>
			<script>
				var mySwiper = new Swiper('.swiper-container', {
					pagination : '.pagination',
					loop : true,
					grabCursor : true,
					paginationClickable : true
				})
				$('.arrow_left').on('click', function(e) {
					e.preventDefault()
					mySwiper.swipePrev()
				})
				$('.arrow_right').on('click', function(e) {
					e.preventDefault()
					mySwiper.swipeNext()
				})
			</script>
		</div>
		<div class="shareHouseTitle">
			<h3>${shareHouse.title}</h3>
			<div>
				<button type="button" name="interestShareHouseCreateBtn"
					class="interestShareHouseCreateBtnOn" title="관심하우스 등록">
					<span class="hide">등록</span>
				</button>
				<button type="button" name="interestShareHouseCreateBtn"
					class="interestShareHouseCreateBtnOff" title="관심하우스 등록">
					<span class="hide">삭제</span>
				</button>
			</div>
			<c:choose>
				<c:when test="${roomList[0].sex eq '여성 전용'}">
					<p class="woman">여성전용</p>
				</c:when>
				<c:when test="${roomList[0].sex eq '남성 전용'}">
					<p class="man">남성전용</p>
				</c:when>
				<c:otherwise>
					<p class="unisex">성별무관</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<section>
		<div></div>
		<article class="shareHouseInfoText">
			<h4>셰어하우스 정보</h4>
			<p>${shareHouse.content }</p>
		</article>
		<div>
			<article id="houseInfo">
				<h4>하우스 정보</h4>
				<p>주거 형태 : ${essentialInfo.buildingType}</p>
				<div>
					<ul class="infoBox">
						<li>하우스 제목 : ${house.houseName }</li>
						<li>전체 면적 : ${house.wholeArea }㎡</li>
						<li>방 개수 : ${house.rooms }</li>
						<li>화장실 수 : ${house.bathrooms }</li>
						<li>
							<ul class="clear">
								<li>층/총층 : ${essentialInfo.floorTotalFloor }</li>
								<c:forEach var="publicUsage"
									items="${essentialInfo.publicUsages}">
									<li>${publicUsage.publicUsage}</li>
								</c:forEach>
								<li>주차 : ${essentialInfo.parking }</li>
								<li>엘리베이터 : ${essentialInfo.lift }</li>
							</ul>
						</li>
						<li>
							<ul class="clear">
								<li>반려동물 : ${extraInfo.pet }</li>
								<li>흡연 : ${extraInfo.smoke }</li>
							</ul>
						</li>
					</ul>
				</div>
			</article>
			<article id="roomInfo">
				<h4>룸 정보</h4>
				<ul class="infoBox">
					<c:choose>
						<c:when test="${roomList[0].sex eq '여성 전용'}">
							<p class="woman">여성전용</p>
						</c:when>
						<c:when test="${roomList[0].sex eq '남성 전용'}">
							<p class="man">남성전용</p>
						</c:when>
						<c:otherwise>
							<p class="unisex">성별무관</p>
						</c:otherwise>
					</c:choose>
					<li>룸 크기 : ${roomList[0].roomArea }㎡</li>
					<li>보증금 : ${roomList[0].deposit }(만원)</li>
					<li>월세 : ${roomList[0].monthlyFee }(만원)</li>
					<li>
						<ul class="clear">
							<c:forEach var="providedGood"
								items="${roomList[0].providedGoods }">
								<li>${providedGood.providedGood}</li>
							</c:forEach>
						</ul>
					</li>
				</ul>
			</article>
		</div>
		<div>
			<h4>후기</h4>
			<div class="listHead">
				<span>셰어하우스 제목</span> <span>후기 작성 날짜</span> <span>작성자</span>
			</div>
			<ul id="reviewList" class="questionList">
				<c:if test="${reviews ne null }">
					<c:forEach var="review" items="${reviews }">
						<li><a href="${ctx}/views/reviewDetail.do"> <span>${review.title}</span>
								<span>${review.writerId}</span> <span>${review.date}</span>
						</a></li>
					</c:forEach>
				</c:if>
				<c:if test="${reviews eq null }">
					<li>해당 셰어하우스에 후기가 없습니다.</li>
				</c:if>
			</ul>
			<div class="paging">
				<!-- 후기 페이징 부분 -->
				<ul class="clear">
					<%-- 			
					<c:forEach var="pageNumber" items="paging" end="5">
						<li><a href="#a">${pageNumber.pageNumber}</a></li>
					</c:forEach>
	--%>
				</ul>
			</div>
		</div>


	</section>
	<aside>
		<div id="map"></div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20a2231eb9d4b20ef7a68674b0d5aca3&libraries=services"></script>
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				level : 5
			};

			var map = new daum.maps.Map(mapContainer, mapOption);

			var geocoder = new daum.maps.services.Geocoder();

			geocoder.addressSearch('${house.address }',
					function(result, status) {

						if (status === daum.maps.services.Status.OK) {

							var coords = new daum.maps.LatLng(result[0].y,
									result[0].x);

							var marker = new daum.maps.Marker({
								map : map,
								position : coords
							});

							map.setCenter(coords);
						}
					});
		</script>
		<a
			href="${ctx}/question/registQuestion.do?shareHouseId=${shareHouse.shareHouseId }">하우스
			방문 문의</a>
	</aside>
	</main>
	<%@ include file="/views/layout/footer.jsp"%>
</body>
</html>