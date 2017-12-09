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
		<form action="${ctx}/shareHousefList.do" method="get">
			<input type="search" name="searchShareHouse" placeholder="search">
			<input type="submit" value="검색하기">
		</form>

		<div id="map" style="width: 100%; height: 250px;"></div>
		<h4>주소</h4>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20a2231eb9d4b20ef7a68674b0d5aca3&libraries=services"></script>
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center : new daum.maps.LatLng(37.569, 126.979), // 지도의 중심좌표
				level : 7
			// 지도의 확대 레벨37.541° 126.986°
			};

			// 지도를 생성합니다    
			var map = new daum.maps.Map(mapContainer, mapOption);

			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new daum.maps.services.Geocoder();

			// 주소로 좌표를 검색합니다
			geocoder.addressSearch('${com }',
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === daum.maps.services.Status.OK) {

							var coords = new daum.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new daum.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
		</script>


		<div>
			<h3>[${count }]개의 셰어하우스</h3>
			<ul>
				<c:forEach var="shareHouse" items="${shareHouses}">

					<li><a href="${ctx}/shareHouseDetail.do?="
						${shareHouse.shareHouseId }>
							<h4>셰어하우스 : ${shareHouse.title}</h4>
							<h4>성별 : ${room.sex }</h4>
							<h4>${room.deposit }/${room.monthlyFee }</h4>
					</a></li>

				</c:forEach>
			</ul>
		</div>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>