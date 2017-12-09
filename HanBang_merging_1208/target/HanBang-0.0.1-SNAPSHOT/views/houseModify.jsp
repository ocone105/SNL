<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<title>한방</title>
<%@ include file="/views/layout/common.jsp" %>
</head>

<body>

<%@ include file="/views/layout/header.jsp" %>

<main>
	<section>
		<h3>하우스 수정</h3>
		<p>${house.houseName } 정보입니다.</p>
		<form action="${ctx}/houseModify.do" method="POST">
			<div>
				<div>
					<div id="map" style="width: 100%; height: 250px;"></div>
					<h4> 주소</h4>
					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20a2231eb9d4b20ef7a68674b0d5aca3&libraries=services"></script>
					<script>
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
						mapOption = {
							center : new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
							level : 6
						};

						var map = new daum.maps.Map(mapContainer, mapOption);

						var geocoder = new daum.maps.services.Geocoder();

						geocoder.addressSearch('${house.address }', function(result,
								status) {

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
					<input type="text" id="sample4_roadAddress" name="address" value="${house.address }"
						> <input type="button"
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
				<input type="text" name="houseName" value="${house.houseName }">
				<input type="number" name="wholeArea" value="${house.wholeArea}">
				<input type="number" name="rooms" value="${house.rooms }">
				<input type="number" name="bathrooms" value="${house.bathrooms }">
				<input type="hidden" name ="memberId" value="${house.memberId }">
				<input type="hidden" name ="houseId" value="${house.houseId }">
				
			</div>
			<input type="submit" name="houseModifyBtn" value="수정하기">
		</form>
	</section>
</main>

<%@ include file="/views/layout/footer.jsp" %>

</body>
</html>