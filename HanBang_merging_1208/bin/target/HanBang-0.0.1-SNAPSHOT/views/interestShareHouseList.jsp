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
		<h3>관심하우스</h3>
		<form action="${ctx}/interestShareHousedelete.do" method="get">


			<c:if test="${interestShareHouses ne null }">
				<c:forEach var="interestHouse" items="${interestShareHouses}">
					<div class="shareHouseValue">
						<input type="checkbox" id="interestHouseDeleteCheck"
							name="interestHouseDeleteCheck"> <label class="hide"
							for="interestShareHouseDeleteCheck">셰어하우스 삭제</label> <a
							href="${ctx}/shareHouseDetail.do">
							<h4>${interestHouse.title}</h4> 
							<c:choose>
								<c:when test="${interestHouse.rooms[0].sex eq '여성전용'}">
									<p class="woman">여성전용</p>
								</c:when>
								<c:when test="${interestHouse.rooms[0].sex eq '남성전용'}">
									<p class="man">남성전용</p>
								</c:when>
								<c:otherwise>
									<p class="unisex">성별무관</p>
								</c:otherwise>
							</c:choose> 
							<c:forEach var="house" items="${houses }">
								<c:if test="${interestHouse.houseId eq house.houseId }">
									<span>${house.rooms}</span>
									<span>${house.bathrooms}</span>
								</c:if>
							</c:forEach>
							<span>${interestHouse.essentialInfo.buildingType}</span>
							<p>${interestHouse.rooms[0].deposit }/
								${interestHouse.rooms[0].monthlyFee }</p>
						</a>
						<div>
							<a href="${ctx}/questionCreate.jsp" target="_blank">하우스 방문 문의</a>
						</div>
						<input type="submit" name="interestShareHouseDeleteBtn" value="삭제">
					</div>
					
				</c:forEach>
					
			</c:if>
			<c:if test="${interestShareHouse eq null}">
				<div class="shareHouseNull">
					<span>!</span>관심하우스로 등록된 셰어하우스가 없습니다.
				</div>
			</c:if>


		</form>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>