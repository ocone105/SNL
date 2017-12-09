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


	<section>
		<h3>셰어하우스 수정</h3>
		<form action="${ctx }/shareHouse/shareHouseModify.do" method="post"
			class="shareHouseCreate" enctype="multipart/form-data">
			<input type="hidden" name="shareHouseId"
				value="${shareHouse.shareHouseId }"> <input type="text"
				name="title" placeholder="제목" value=${shareHouse.title }>
			<div>
				<div class="houseInfo">
					<h4>하우스</h4>
					<div class="clear">
						<div class="shareHouseCreateMapView">
							<!-- 지도 -->
							<div id="map" style="width: 25%; height: 25%;"></div>
							<script type="text/javascript"
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20a2231eb9d4b20ef7a68674b0d5aca3&libraries=services"></script>
							<script>
								var mapContainer = document
										.getElementById('map'), // 지도를 표시할 div 
								mapOption = {
									center : new daum.maps.LatLng(37.569,
											126.979), // 지도의 중심좌표
									level : 7
								// 지도의 확대 레벨37.541° 126.986°
								};

								// 지도를 생성합니다    
								var map = new daum.maps.Map(mapContainer,
										mapOption);

								// 주소-좌표 변환 객체를 생성합니다
								var geocoder = new daum.maps.services.Geocoder();

								// 주소로 좌표를 검색합니다
								geocoder
										.addressSearch(
												'${house.address }',
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
							<input type="hidden" name="houseId" value="${house.houseId }">
							<label>하우스 이름<input type="text" name="houseName"
								value="${house.houseName }" readonly="readonly">
							</label><label>주소<input type="text" id="sample4_roadAddress"
								name="address" value="${house.address }" placeholder="도로명주소"
								readonly="readonly"></label> <label>전체 면적<input
								type="text" name="wholeArea" value="${house.wholeArea }"
								readonly="readonly">
							</label> <label>룸 개수<input type="number" name="roomEa"
								value="${house.rooms }" readonly="readonly"></label> <label>화장실
								개수<input type="number" name="bathrooms"
								value="${house.bathrooms }" readonly="readonly">
							</label>
						</div>
					</div>
				</div>
				<div class="shareHouseInfo clear">
					<h4>하우스 정보 및 공용 공간 옵션</h4>
					<div>
						<div class="buildingType ea4 clear">
							<label> <input type="radio" name="buildingType"
								value="단독주택"
								<c:if test="${essentialInfo.buildingType eq '단독주택' }">checked="checked"</c:if>>
								<span>단독주택</span>
							</label> <label> <input type="radio" name="buildingType"
								value="빌라"
								<c:if test="${essentialInfo.buildingType eq '빌라' }">checked="checked"</c:if>>
								<span>빌라</span>
							</label> <label> <input type="radio" name="buildingType"
								value="아파트"
								<c:if test="${essentialInfo.buildingType eq '아파트' }">checked="checked"</c:if>>
								<span>아파트</span>
							</label> <label> <input type="radio" name="buildingType"
								value="오피스텔"
								<c:if test="${essentialInfo.buildingType eq '오피스텔' }">checked="checked"</c:if>>
								<span>오피스텔</span>
							</label>
						</div>
						<label>층/총층<input type="text" name="floorTotalFloor"
							value=${essentialInfo.floorTotalFloor }></label>
						<div class="essentialInfo ea2 clear">
							<label> <input type="checkbox" name="parking" value="가능">
								<span>주차</span>
							</label> <label> <input type="checkbox" name="lift" value="유">
								<span>엘리베이터</span>
							</label>
						</div>
						<div class="extraInfo ea2 clear">
							<label> <input type="checkbox" name="pet" value="가능">
								<span>반려동물</span>
							</label> <label> <input type="checkbox" name="smoke" value="가능">
								<span>흡연</span>
							</label>
						</div>
					</div>
					<div class="eaNone clear">
						<label> <input type="checkbox" name="publicUsage"
							value="cctv"> <span>CCTV</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="wifi"> <span>와이파이</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="internet"> <span>인터넷</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="livingRoom"> <span>거실</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="veranda"> <span>베란다</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="shoeRack"> <span>신발장</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="tv"> <span>TV</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="airConditioner"> <span>에어컨</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="dishDryer"> <span>식기건조기</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="refrigerator"> <span>냉장고</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="induction"> <span>인덕션</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="gasStove"> <span>가스레인지</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="microwave"> <span>전자레인지</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="oven"> <span>오븐</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="cookware"> <span>조리도구</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="toasters"> <span>토스터기</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="electricPot"> <span>전기포트</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="waterPurifier"> <span>정수기</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="riceCooker"> <span>밥솥</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="desk"> <span>테이블</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="cushion"> <span>쿠션</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="sofa"> <span>소파</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="chair"> <span>의자</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="table"> <span>책상</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="bookcase"> <span>책장</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="vacuum"> <span>청소기</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="iron"> <span>다리미</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="washer"> <span>세탁기</span>
						</label> <label> <input type="checkbox" name="publicUsage"
							value="recycleBin"> <span>분리수거함</span>
						</label>
					</div>
				</div>
				<div class="roomInfo">
					<h4>룸 정보</h4>
					<div>
						<div class="ea3 clear">
							<label> <input type="radio" name="shareHouseGender"
								value="성별 무관"
								<c:if test="${roomList[0].getSex() eq '성별 무관' }">checked="checked"</c:if>>
								<span>성별 무관</span>
							</label> <label> <input type="radio" name="shareHouseGender"
								value="여성 전용"
								<c:if test="${roomList[0].getSex() eq '여성 전용' }">checked="checked"</c:if>>
								<span>여성 전용</span>
							</label> <label> <input type="radio" name="shareHouseGender"
								value="남성 전용"
								<c:if test="${roomList[0].getSex() eq '남성 전용' }">checked="checked"</c:if>>
								<span>남성 전용</span>
							</label>
						</div>
						<div class="clear">
							<div>
								<label>룸 크기<input type="text" name="roomArea"
									value=${roomList[0].getRoomArea() }></label> <label>화장실
									유/무<input type="text" name="bathroom"
									value=${roomList[0].getBathroom() }>
								</label> <label>보증금<input type="text" name="deposit"
									value=${roomList[0].getDeposit() }></label> <label>월세<input
									type="text" name="monthlyFee"
									value=${roomList[0].getMonthlyFee() }></label> <label>입주
									가능 여부<input type="text" name="availability"
									value=${roomList[0].getAvailability() }>
								</label>
							</div>
							<div class="roomOption clear">
								<label> <input type="checkbox" name="providedGood"
									value="roomAirConditioner"> <span>에어컨</span>
								</label> <label> <input type="checkbox" name="providedGood"
									value="roomDesk"> <span>책상</span>
								</label> <label> <input type="checkbox" name="providedGood"
									value="roomChair"> <span>의자</span>
								</label> <label> <input type="checkbox" name="providedGood"
									value="roomStand"> <span>스탠드</span>
								</label> <label> <input type="checkbox" name="providedGood"
									value="roomBed"> <span>침대</span>
								</label> <label> <input type="checkbox" name="providedGood"
									value="roomDrawer"> <span>서랍장</span>
								</label> <label> <input type="checkbox" name="providedGood"
									value="roomStorage"> <span>수납함</span>
								</label>
							</div>
						</div>
					</div>
					<button type="button" name="roomCreateBtn" class="roomCreateBtn">추가하기</button>
				</div>
				<textarea rows="30" cols="100" placeholder="작성해주세요" name="content">${shareHouse.content }</textarea>
			</div>
			<div class="fileUpLoad">
				<p>하우스 대표 사진</p>
				<label><input type="file" name="photos" multiple="multiple"></label>
			</div>
			<input type="submit" name="shareHouseModifyBtn" value="수정하기">
		</form>
	</section>


	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>