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

	<main class="shareHouseListMain">
	<section>
		<div class="clear">
			<div class="shareHouseListMapView">
				<form action="${ctx}/shareHouseList.do" method="get"
					class="searchBar">
					<input type="text" name="searchShareHouse"
						placeholder="지역명, 대학교, 지하철역을 입력해 주세요."> <input
						type="submit" name="searchShareHouseBtn" value="검색하기">
				</form>

				<div id="map"></div>
				<script src="https://code.jquery.com/jquery-2.2.3.js"></script>
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20a2231eb9d4b20ef7a68674b0d5aca3&libraries=services"></script>
				<script>
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center : new daum.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
						level : 13
					};

					// 지도를 생성합니다    
					var map = new daum.maps.Map(mapContainer, mapOption);
					var arra = [];
					var title = [];

					<c:forEach var="item" items="${list }">
					arra.push("${item}");
					</c:forEach>

					<c:forEach var="item" items="${shareHouses }">
					title.push("${item.title}");
					</c:forEach>

					var geocoder = new daum.maps.services.Geocoder();

					$
							.each(
									arra,
									function(i) {
										$
												.each(
														title,
														function(i) {
															geocoder
																	.addressSearch(
																			arra[i],
																			function(
																					result,
																					status) {

																				if (status === daum.maps.services.Status.OK) {

																					var coords = new daum.maps.LatLng(
																							result[0].y,
																							result[0].x);

																					var marker = new daum.maps.Marker(
																							{
																								map : map,
																								position : coords
																							});

																					var iwContent = '<div style="padding:5px;">'
																							+ title[i]
																							+ '</div>';

																					var infowindow = new daum.maps.InfoWindow(
																							{
																								content : iwContent
																							});

																					daum.maps.event
																							.addListener(
																									marker,
																									'mouseover',
																									function() {
																										infowindow
																												.open(
																														map,
																														marker);
																									});

																					daum.maps.event
																							.addListener(
																									marker,
																									'mouseout',
																									function() {
																										infowindow
																												.close();
																									});
																				}
																			});
														})
									})
				</script>



				<!--  -->
			</div>
			<div class="shareHouseList">
				<h3>[${size}]개의 셰어하우스</h3>
				<ul>
					<c:forEach var="shareHouse" items="${shareHouses }">
						<li>
							<a href="${ctx}/shareHouse/shareHouseDetail.do?shareHouseId=${shareHouse.shareHouseId}">
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
									<p>${shareHouse.rooms[0].deposit } / ${shareHouse.rooms[0].monthlyFee }</p>
								</div>
							</a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</section>
	</main>

</body>
</html>