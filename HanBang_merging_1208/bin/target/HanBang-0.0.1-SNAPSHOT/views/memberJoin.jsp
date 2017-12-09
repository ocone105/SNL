<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8" http-equiv="Content-Type" content="text/html">
<title>한방</title>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://cdn.jsdelivr.net/parsleyjs/2.0.0-rc4/parsley.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#id").keyup(function() {

			if ($("#id").val().length > 5) {
				//ajax
				var id = $(this).val();
				$.ajax({ //객체선언
					type : 'POST',
					url : 'checkId.do',
					data : {
						id : id
					//키값:실제값
					},
					success : function(result) {
						if ($.trim(result) == 'ok') {
							$("#idCheckResult").html("사용 가능한 ID 입니다.");
						} else {
							$("#idCheckResult").html("사용 중인 ID 입니다.");
						}
					}
				});

				if ($("#id").val().length > 9) {
					$("#idCheckResult").html("ID는 8자 이하입니다.");
				}
			} else if ($("#id").val().length < 5) {
				$("#idCheckResult").html("ID는 5자 이상입니다.");
			} else {
				$("#idCheckResult").html("");
			}
		});
	});
</script>


<script type="text/javascript">
	function validate() {

		var userid = document.getElementById("id");

		// 첫글자는 반드시 영문소문자, 4~12자로 이루어지고, 숫자가  하나 이상 포함되어야한다.

		// 영문소문자와 숫자로만 이루어져야 한다.

		// \d : [0-9]와 같다. {n,m} : n에서 m사이

		if (!chk(/^[a-z][a-z\d]{6,10}$/, userid,
				"ID는 6-10자 이내로 입력해주세요.(영문,숫자 포함)"))
			return false;

		if (!chk(/[\d]/, userid, "ID는 6-10자 이내로 입력해주세요.(영문,숫자 포함)"))
			return false;

		//alert(re.test(userid.value));

		var pass = document.getElementById("password1");

		var pass1 = document.getElementById("password2");

		if (!chk(/^[a-z][a-z\d]{7,13}$/, pass,
				"비밀번호는  8-12자 이내로 입력해주세요.(영문,숫자 포함)")) {
			return false;
		}

		if (!pwchk(pass, pass1, "비밀번호가 일치하지 않습니다."))
			return false;

		var name = document.getElementById("name");

		if (!chk(/^[가-힝]{2,}$/, name, "2글자 이상 한글만 입력해주세요"))
			return false;

		var email = document.getElementById("email");

		if (!chk(/^[\w-]{4,}@[\w-]+(\.\w+){1,3}$/, email, "이메일 형식이 잘못되었습니다."))
			return false;

		var tel1 = document.getElementById("phoneNumber");

		if (tel1.value != '') {

			if (!chk(/^\d{1,11}$/, tel1, "전화번호 형식이 잘못되었습니다."))
				return false;

		}
	}
	function chk(re, e, msg) {

		if (re.test(e.value))
			return true;

		alert(msg);

		e.value = "";

		e.focus();

		return false;

	}

	function pwchk(e1, e2, msg) {

		if (e1.value = e2.value)
			return true;

		alert(msg);

		e.value = "";

		e.focus();

		return true;

	}
</script>






<%@ include file="/views/layout/common.jsp"%>
</head>

<body>

	<c:set var="memberType" value="1" />
	<c:set var="memberType" value="2" />

	<a href="#header" class="skip">본문바로가기</a>

	<header id="header" class="memberJoinHeader">
		<h1>
			<a href="${ctx}/index.jsp">한방</a>
		</h1>
		<nav>
			<h2 class="hide">회원 메뉴</h2>
			<ul>
				<li><a href="${ctx}/views/login.jsp">로그인</a></li>
			</ul>
		</nav>
	</header>

	<main>
	<section class="memberJoinSection">
		<h3>회원 가입</h3>
		<p>한방에 오신 것을 환영합니다.</p>
		<form action="${ctx}/memberJoin.do" method="post"
			onsubmit="return validate();">
			<div class="memberType clear">
				<label><input type="radio" name="memberTypeId" value="1">
					<span>일반 회원</span> </label> <label> <input type="radio"
					name="memberTypeId" value="2"> <span>사업자</span></label>
			</div>
			<div>

				<input type="text" id="id" name="id" placeholder="아이디"> <span
					id="idCheckResult"></span> <input type="password" name="password"
					id="password1" placeholder="비밀번호"> <input type="password"
					id="password2" name="passwordCheck" placeholder="비밀번호 확인">
				<span id="check"></span>
			</div>
			<div>
				<input type="text" id="name" name="name" placeholder="이름"> <input
					type="tel" id="phoneNumber" name="phoneNumber" placeholder="연락처">
				<input type="email" id="email" name="email" placeholder="이메일">
			</div>
			<input type="submit" name="memberJoinBtn" value="가입하기">

		</form>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>