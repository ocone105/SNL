<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<a href="#header" class="skip">본문바로가기</a>

<header id="header">
	<div class="clear">
		<h1>
			<a href="${ctx}/index.do">한방</a>
		</h1>
		<c:if test="${memberId eq null}">
			<nav class="memberMenu clear">
				<h2 class="hide">회원 메뉴</h2>
				<a href="${ctx}/shareHouse/shareHouseList.do">하우스 찾기</a>
				<ul>
					<li><a href="${ctx}/views/login.jsp">로그인</a></li>
					<li><a href="${ctx}/views/memberJoin.jsp">회원 가입</a></li>
				</ul>
			</nav>
		</c:if>
		<c:if test="${memberType eq '1' }">
			<nav class="memberMenu clear">
				<h2 class="hide">회원 메뉴</h2>
				<a href="${ctx}/shareHouse/shareHouseList.do">하우스 찾기</a>
				<ul>
					<li><a href="${ctx}/logout.do">로그아웃</a></li>
				</ul>
			</nav>
			<ul class="gnb clear">
				<li><a href="${ctx}/findMember.do">내 프로필</a></li>
				<li><a href="${ctx}/interestShareHouseList.do">관심하우스</a></li>
				<li><a href="${ctx}/question/questionList.do">문의 내역</a></li>
			</ul>
		</c:if>

		<c:if test="${memberType eq '2' }">
			<nav class="memberMenu clear">
				<h2 class="hide">회원 메뉴</h2>
				<a href="${ctx}/shareHouse/shareHouseList.do">하우스 찾기</a>
				<ul>
					<li><a href="${ctx}/logout.do">로그아웃</a></li>
				</ul>
			</nav>
			<ul class="gnb clear">
				<li><a href="${ctx}/findMember.do">내 프로필</a></li>
				<li><a href="${ctx}/myHouse.do">마이하우스</a></li>
				<li><a href="${ctx}/question/questionList.do">문의 내역</a></li>
			</ul>
		</c:if>
		<c:if test="${memberId eq 'admin' }">
			<nav class="memberMenu clear">
				<h2 class="hide">회원 메뉴</h2>
				<a href="${ctx}/allMemberList.do">회원 관리</a> <a
					href="${ctx}/shareHouse/shareHouseList.do">하우스 찾기</a>
				<ul>
					<li><a href="${ctx}/logout.do">로그아웃</a></li>
				</ul>
			</nav>
			<ul class="gnb clear">
				<li><a href="${ctx}/providerList.do">사업자</a></li>
				<li><a href="${ctx}/userList.do">일반 회원</a></li>
			</ul>
		</c:if>


	</div>
</header>