$(function() {
	$("#datepicker").datepicker({
		showOn : "button",
		buttonImage : "../images/buico/ico_calendar.gif",
		buttonImageOnly : true,
		buttonText : "방문 가능 날짜"
	});
});

$(function() {
	$('.detail').accordion({
		heightStyle : "content"
	});
});





//$("document").ready(function () {
//    // <a> 태그에 포커스 맞춰질 때 폰트 색상 변경
//    $("a").focusin(function () {
//    	$(this).css("color", "#F00");
//    });
//
//    $("a").focusout(function () {
//    	$(this).css("color", "inherit");
//    });
//
//    // 메뉴 드롭다운
//    $("ul.menu > li").mouseover(function () {
//    	$(this).children(".submenu").stop().slideDown();
//    });
//
//    $("ul.menu > li").mouseout(function () {
//    	$(this).children(".submenu").stop().slideUp();
//    });
//
//    // Partner 이미지들을 선택하여 click 이벤트를 걸어준다.
//    $(".partner-logo img").click(function () {
//        // Partner 이미지들이 클릭되었을 때 아래의 코드가 실행된다.
//        $(".modal").show();
//    });
//
//    // 모달창의 닫기버튼을 선택하여 click 이벤트를 걸어준다.
//    $(".modal .content button").click(function () {
//        // 모달창의 닫기버튼을 클릭 시 아래의 코드가 실행된다.
//        $(".modal").hide();
//    });
