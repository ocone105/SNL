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

	<main class="houseCreate">
	<section>
		<h3>하우스 등록</h3>
		<p>보유하신 하우스 정보를 입력해주세요.</p>
		<form action="${ctx}/houseRegister.do" method="POST">

			<div class="houseMapView">
				<div id="map_reload">
					<div id="map"></div>
					<div class="clear">
						<input type="text" id="sample4_roadAddress" name="address"
							placeholder="도로명주소">
						<input type="button"
						onclick="sample5_execDaumPostcode()" value="주소 찾기"><br>
					</div>
				</div>
				<div>

					<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20a2231eb9d4b20ef7a68674b0d5aca3&libraries=services"></script>
					<script>
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div
						mapOption = {
							center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
							level : 5
						// 지도의 확대 레벨
						};

						var map = new daum.maps.Map(mapContainer, mapOption);
						var geocoder = new daum.maps.services.Geocoder();
						var marker = new daum.maps.Marker({
							position : new daum.maps.LatLng(37.537187,
									127.005476),
							map : map
						});

						function sample5_execDaumPostcode() {
							new daum.Postcode(
									{
										oncomplete : function(data) {
											var fullAddr = data.address; // 최종 주소 변수
											var extraAddr = ''; // 조합형 주소 변수

											if (data.addressType === 'R') {
												if (data.bname !== '') {
													extraAddr += data.bname;
												}
												if (data.buildingName !== '') {
													extraAddr += (extraAddr !== '' ? ', '
															+ data.buildingName
															: data.buildingName);
												}
												fullAddr += (extraAddr !== '' ? ' ('
														+ extraAddr + ')'
														: '');
											}

											document
													.getElementById("sample4_roadAddress").value = fullAddr;
											geocoder
													.addressSearch(
															data.address,
															function(results,
																	status) {
																if (status === daum.maps.services.Status.OK) {

																	var result = results[0]; //첫번째 결과의 값을 활용

																	// 해당 주소에 대한 좌표를 받아서
																	var coords = new daum.maps.LatLng(
																			result.y,
																			result.x);
																	mapContainer.style.display = "block";
																	map
																			.relayout();
																	map
																			.setCenter(coords);
																	marker
																			.setPosition(coords)
																}
															});
										}
									}).open();
						}
					</script>
				</div>
				<input type="text" name="houseName" placeholder="하우스 이름"> <input
					type="number" name="wholeArea" placeholder="전체 면적(㎡)"> <input
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