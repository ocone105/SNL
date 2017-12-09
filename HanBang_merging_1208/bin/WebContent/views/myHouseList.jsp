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
		<h3>마이하우스</h3>
		<form action="${ctx}/myHouseDelete.do" method="get">
			<c:if test="${shareHouses ne null }">
				<c:forEach var="shareHouse" items="${shareHouses}">
					<div class="shareHouseValue">
						<input type="checkbox" id="myHouseDelete" name="myHouseDelete">
						<label class="hide" for="myHouseDelete">마이하우스 삭제</label> <a
							href="${ctx}/shareHouse/shareHouseDetail.do?shareHouseId=${shareHouse.shareHouseId}">
							<h4>${shareHouse.title}</h4> <c:choose>
								<c:when test="${shareHouse.rooms[0].sex eq '여성 전용'}">
									<p class="woman">여성전용</p>
								</c:when>
								<c:when test="${shareHouse.rooms[0].sex eq '남성 전용'}">
									<p class="man">남성전용</p>
								</c:when>
								<c:otherwise>
									<p class="unisex">성별무관</p>
								</c:otherwise>
							</c:choose>
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
							</div>
							<p>${shareHouse.rooms[0].deposit }/
								${shareHouse.rooms[0].monthlyFee }</p>
						</a>
						<div>
							<input type="submit" name="myHouseDeleteBtn" value="삭제">
						</div>
						<div>
							<a
								href="${ctx}/shareHouse/shareHouseModify.do?shareHouseId=${shareHouse.shareHouseId }">셰어하우스 수정하기</a>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${interestShareHouse eq 'null'}">
				<div class="shareHouseNull">
					<span>!</span>등록된 셰어하우스가 없습니다.
					<p>무료로 셰어하우스를 등록해 보세요.</p>
				</div>
			</c:if>
			<input type="submit" name="myHouseDeleteBtn" value="삭제">
		</form>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>