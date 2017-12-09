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
                  id : id  //키값:실제값
               },
               success : function(result) {
                  if ($.trim(result) == 'ok') {
                     $("#idCheckResult").html("사용 가능한 ID 입니다.");
                  }else{
                     $("#idCheckResult").html("사용 중인 ID 입니다.");
                  }
               }
            });
            
            if($("#id").val().length > 9){
           	 $("#idCheckResult").html("ID는 8자 이하입니다.");
            }
         }else {
            $("#idCheckResult").html("ID는 5자 이상입니다.");
         }
      });
   });
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
		<form action="${ctx}/memberJoin.do" method="post">
			<label><input type="radio" name="memberTypeId" value="1">일반
				회원</label> <label><input type="radio" name="memberTypeId" value="2">사업자</label>
				<div>
				
					<input type="text" 	id="id" name="id" placeholder="아이디">
					<span id ="idCheckResult"></span>
					
					 <input
						type="password" name="password" placeholder="비밀번호"> <input
						type="password" name="passwordCheck" placeholder="비밀번호 확인">
				</div>
				<div>
					<input type="text" name="name" placeholder="이름"> <input
						type="tel" name="phoneNumber" placeholder="연락처"> <input
						type="email" name="email" placeholder="이메일">
				</div>
				<input type="submit" name="memberJoinBtn" value="가입하기">
		
		</form>
	</section>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
</html>