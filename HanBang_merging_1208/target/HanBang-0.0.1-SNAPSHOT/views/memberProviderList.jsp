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
		<h3>사업자</h3>
		<ul>
			<li>
				<span>사업자 ID</span>
				<span>셰어하우스 갯수 / 신고 횟수</span>
				<span>자동 삭제 셰어하우스 횟수</span>
				<span>삭제</span>
			</li>
			<c:forEach var="provider" items="providerList">
				<li>
					<div>
						<span>${provider.providerId}</span>
						<span>${provider.shareHouseEA} / ${provider.shareHouseReportEA}</span>
						<span>${provider.autoDeleteShareHouseEA}</span>
						<button type="button" name="providerDeleteBtn">삭제</button>
					</div>
					<div>
						<h4>[${provider.providerId}]의 정보</h4>
						<ul>
							<c:forEach var="shareHouse" items="shareHouseList" end="">
								<li>
									<a href="${ctx}/shareHouseDetail.do">
										<span>${shareHouse.shareHouseTitle}</span>
										<span>${shareHouse.shareHouseReportEA}</span>
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</li>
			</c:forEach>
		</ul>
	</section>
</main>

<%@ include file="/views/layout/footer.jsp" %>

</body>
</html>