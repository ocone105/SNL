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
		<h3>하우스 등록</h3>
		<p>보유하신 하우스 정보를 입력해주세요.</p>
		<form action="${ctx}/houseRegister.do" method="POST">

			<div>
				<div id="map_reload">
					<div id="map" style="width: 100%; height: 230px;"></div>
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

						var map = new daum.maps.Map(mapContainer, mapOption);

						var geocoder = new daum.maps.services.Geocoder();

						// 주소로 좌표를 검색합니다
						geocoder
								.addressSearch(
										'${sample4_roadAddress }',
										function(result, status) {
											// 정상적으로 검색이 완료됐으면 
											if (status === daum.maps.services.Status.OK) {
												var coords = new daum.maps.LatLng(
														result[0].y,
														result[0].x);

												// 결과값으로 받은 위치를 마커로 표시합니다
												var marker = new daum.maps.Marker(
														{
															map : map,
															position : coords
														});
												// 인포윈도우로 장소에 대한 설명을 표시합니다

												// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
												map.setCenter(coords);
											}
										});
					</script>
				</div>
				<div>
					<input type="text" id="sample4_roadAddress" name="address"
						placeholder="도로명주소"> <input type="button"
						onclick="sample4_execDaumPostcode()" value="주소 찾기"><br>
					<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
					<script>
						function sample4_execDaumPostcode() {
							new daum.Postcode(
									{
										oncomplete : function(data) {

											var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
											var extraRoadAddr = ''; // 도로명 조합형 주소 변수

											if (data.bname !== ''
													&& /[동|로|가]$/g
															.test(data.bname)) {
												extraRoadAddr += data.bname;
											}
											if (data.buildingName !== ''
													&& data.apartment === 'Y') {
												extraRoadAddr += (extraRoadAddr !== '' ? ', '
														+ data.buildingName
														: data.buildingName);
											}
											if (extraRoadAddr !== '') {
												extraRoadAddr = ' ('
														+ extraRoadAddr + ')';
											}
											if (fullRoadAddr !== '') {
												fullRoadAddr += extraRoadAddr;
											}
											document
													.getElementById('sample4_roadAddress').value = fullRoadAddr;
										}
									}).open();
						}
					</script>
				</div>
				<input type="text" name="houseName" placeholder="하우스 이름"> <input
					type="number" name="wholeArea" placeholder="전체 면적(m^2)"> <input
					type="number" name="rooms" placeholder="룸 개수"> <input
					type="number" name="bathrooms" placeholder="화장실 개수">

			</div>
			<input type="submit" name="houseCreateBtn" value="등록하기">
		</form>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>