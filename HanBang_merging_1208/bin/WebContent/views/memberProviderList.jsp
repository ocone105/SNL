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
		<h3>사업자</h3>
		<div class="listHead">
			<span>사업자 ID </span> <span> 셰어하우스 갯수 / 신고 횟수</span> <span> 자동
				삭제 셰어하우스 횟수</span> <span> 삭제</span>
		</div>
		<div class="detail">

			<c:forEach var="provider" items="${members }">
			
				<div>
					<div>
						<span>${provider.id }</span> 
						<span><c:forEach var="m" items="${map }">
								<c:if test="${m.key eq provider.id }"> 
								 ${m.value } 
								 </c:if>
								 </c:forEach></span>
								 <span> </span>
					</div>
				</div>
				<div>
					<div>
						<h4>[${provider.id}]님의 셰어하우스</h4>
						<ul>
							<c:forEach var="shareHouse" items="${shareHouses }">
								<c:if test="${shareHouse.writerId  eq provider.id }">
									<li><a
										href="${ctx}/shareHouse/shareHouseDetail.do?shareHouseId=${shareHouse.shareHouseId }">
											<span>${shareHouse.title }</span> <span>${shareHouse.shareHouseDate }</span>
									</a></li>
								</c:if>
							</c:forEach>
						</ul>
						<button type="button" name="userDeleteBtn">삭제</button>
						<a href="${ctx}/adminFindMember.do?memberId=${provider.id}">[${provider.id}]님의
							정보 더보기</a> <a href="${ctx }/removeMember.do?memberId=${provider.id }">
						</a>
					</div>
				</div>

			</c:forEach>
		</div>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>