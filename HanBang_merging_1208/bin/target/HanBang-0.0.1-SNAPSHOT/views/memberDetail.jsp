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
	<section class="memberModifySection">
		<h3>회원 정보</h3>
		<p>[${member.name }]님의 정보 입니다.</p>
		<form action="${ctx}/modifyMember.do" method="get">
			<div>
				<label>아이디 <input type="text" name="id"
					placeholder="${member.id }" readonly></label>
			</div>
			<div>
				<label>이름<input type="text" name="name"
					placeholder="${member.name }" readonly></label> <label>연락처<input
					type="tel" name="phoneNumber" placeholder="${member.phoneNumber }"
					readonly></label> <label>이메일<input type="email"
					name="email" placeholder="${member.email }" readonly></label>
			</div>
			<div class="houseOwned">
				<c:if test="${memberType eq '2' }">
					<h4>보유 하우스</h4>
					<ul>
						<c:forEach var="house" items="${houses}">
							<li class="clear">
								<ul>
									<li>${house.houseName}하우스</li>
									<li>전체 면적 ${house.wholeArea} ㎡</li>
									<li>룸 ${house.rooms}</li>
									<li>화장실 ${house.bathrooms}</li>
								</ul>
								<div>
									<a href="${ctx}/houseModify.do?houseId=${house.houseId }">수정</a>
									<a href="${ctx}/houseDelete.do?houseId=${house.houseId }">삭제</a>
									<a href="${ctx}/registShareHouse.do?houseId=${house.houseId}">셰어하우스 등록 하기</a>
								</div>
							</li>
						</c:forEach>
					</ul>
					<a href="${ctx}/views/houseCreate.jsp"><span>+</span>하우스 등록 하기</a>
				</c:if>
			</div>
			<c:if test="${memberType ne '3' }">
				<a href="${ctx }/removeMember.do?memberId=${member.id }">회원탈퇴</a>
				<input type="submit" name="memberModifyBtn" value="수정하기">
			</c:if>
			<c:if test="${memberType eq '3' }">
				<a href="${ctx }/removeMember.do?memberId=${member.id }">회원삭제</a>
			</c:if>
		</form>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>