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
		<h3>회원 정보</h3>
		<p>[${name }]님의 정보 입니다.</p>
		<form action="${ctx}/modifyMember.do" method="get">
			<div>
				<label>아이디 <input type="text" name="id"
					placeholder="${memberId }" readonly></label>
			</div>
			<div>
				<label>이름<input type="text" name="name"
					placeholder="${name }" readonly></label> <label>연락처<input
					type="tel" name="phoneNumber" placeholder="${member.phoneNumber }"
					readonly></label> <label>이메일<input type="email"
					name="email" placeholder="${member.email }" readonly></label>
			</div>
			<div>
				<c:if test="${memberType eq '2' }">
					<h4>보유 하우스</h4>
					<ul>
						<c:forEach var="house" items="${houses}">
							<li>
								<p>${name }님의${house.houseName}하우스</p> <a
								href="${ctx}/houseModify.do?houseId=${house.houseId }">수정</a> <a
								href="${ctx}/houseDelete.do?houseId=${house.houseId }">삭제</a> <a
								href="${ctx }/registShareHouse.do?houseId=${house.houseId}">셰어하우스
									등록하기</a>
							</li>
						</c:forEach>
					</ul>
					<a href="${ctx}/views/houseCreate.jsp">하우스 등록 하기</a>
				</c:if>
			</div>

			<a href="${ctx }/removeMember.do">회원탈퇴</a> <input type="submit"
				name="memberModifyBtn" value="수정하기">
		</form>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>