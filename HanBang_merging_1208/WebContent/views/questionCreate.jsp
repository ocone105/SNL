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

<body onload="showmethe();">

	<%@ include file="/views/layout/header.jsp"%>

	<main>
	<section>
		<h3>문의 등록</h3>
		<form action="${ctx}/question/registQuestion.do" method="post">
			 <input type="hidden" id="year"> 
       		 <input type="hidden" id="month"> 
   	    	 <input type="hidden" id="selectedDay"> 
   	    	 <input type="hidden" id="schedule" name="schedule">
			<div>
				<h4>${shareHouseTitle}</h4>
				<label>방문 가능 날짜
				<div id="show"> </div> 
				</label> 
				<!-- <img class="ui-datepicker-trigger" src="../resources/images/buico/ico_calendar.gif" alt="Select date"title="Select date"> -->
				<input type="tel" name="phoneNumber" placeholder="연락처">
				<textarea rows="30" cols="100" name="content"></textarea>
			</div>
			<input type="submit" name="questionCreateBtn" value="문의하기">
		</form>
	</sectionf>
	</main>

	<%@ include file="/views/layout/footer.jsp"%>

</body>
 <script type="text/javascript"> 
 		
        var today = new Date();           // 오늘거 받아온뎌 
        var year = today.getFullYear();   // 년도 
        var month = today.getMonth();     // 달  
        var date = today.getDate();
        document.getElementById("year").value = year;  // 달력의 년도와 달 정보를 담는 변수
        document.getElementById("month").value = month+1; // 
        function prev() { 
            // 전달  
            var yy = document.getElementById("year").value;  
            var mm = document.getElementById("month").value;  
            mm--;  
            if(mm <= 0){   mm = 12;   yy--;  }  
            document.getElementById("year").value = yy;   
            document.getElementById("month").value = mm;    
            showmethe(); 
        }
        function next() {
            // 다음달  
            var yy = document.getElementById("year").value; 
            var mm = document.getElementById("month").value;
            mm++;  
            if(mm > 12){  
                mm = 1;   
                yy++;  
            } 
            document.getElementById("year").value = yy;     
            document.getElementById("month").value = mm;   
            showmethe();  
        } 
        function showmethe(){ 
            // 다 로드되고 바로 시작되는 함수  
            var yy = document.getElementById("year").value;  // 년도와 달을 불러온다  
            var mm = document.getElementById("month").value;
            var show = document.getElementById("show"); // 나중에 출력할 곳 div태그   
            var sum = "<table border='1px' align='center' width='700px'>";   
            sum += "<tr>";   sum += "<td colspan='7' align='center'>";   
            sum += "<a href='#' onclick='prev()'>전</a>&nbsp;&nbsp;&nbsp;";   
            sum += yy + "년 "+mm + "월";   
            sum += "&nbsp;&nbsp;&nbsp;<a href='#' onclick='next()'>후</a>"; 
            sum += "</td>";
            sum += "</tr>";
            sum += "<tr>";
            sum += "<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>"; 
            sum += "</tr>"; 
            sum += "<tr>";
            var w = new Date(yy,mm-1,1).getDay(); // 이번달 1일이 무슨요일인지 보고 일요일(0)~토요일(0) 까지 알아서 공백을 채워준다. 
            for( var i = 0 ; i < w ; i++){
                sum += "<td>&nbsp;</td>"
            }       
            var m = [31,28,31,30,31,30,31,31,30,31,30,31]; // 월의 마지막 날짜를 배열에 넣는다.  
            m[1] = (yy%400==0 || yy%4==0 && yy%100!=0) ? 29 : 28;
            for( i = 1 ; i <= m[mm-1] ; i++ ){   
                // 월마지막달 배열 중 이번달 꺼 빼서 요일에 맞게 알아서 넣음 ... !!!
                if( new Date(yy,mm-1,i).getDay() == 0){
                    sum += "<td align='center' style='color:red;'>"+"<span onclick='checkDay("+yy+","+mm+","+i+")'; style='cursor:pointer; color:red;'>"+i+"</span>" +"</td>";    
                }else if(new Date(yy,mm-1,i).getDay() == 6){ 
                    sum +="<td align='center' style='color:red;'>"+"<span onclick='checkDay("+yy+","+mm+","+i+")'; style='cursor:pointer; color:blue;'>"+i+"</span>" +"</td>";
                }else{     
                    sum += "<td align='center' style='color:red;'>"+"<span onclick='checkDay("+yy+","+mm+","+i+")'; style='cursor:pointer; color:black;'>"+i+"</span>" +"</td>";
                }
                if(new Date(yy,mm-1,i).getDay() == 6){
                    // 토요일이면 행 바꿔주고  
                    sum += "</tr>";
                    if(i != m[m-1]){ // 달마지막과 i 값을 비교하여 같지 않다면 새로운 행을 시작한다. 
                        sum += "<tr>"     }  
                }  
            }  
            w = new Date(yy,mm,1).getDay(); // 다음달 1일의 요일 정보를 찾아온다  
            if(w != 0){  
                for(var i = w ; i <= 6 ; i++){ // 다음달 1일이 시작하는 요일 부터 토요일까지 테이블에 빈칸을 넣어준다. 
                    sum += "<td>&nbsp;</td>";  
                }
            }   
            sum += "</tr>" ;
            sum += "</table>";   
            show.innerHTML = sum;
        }
        
        function checkDay(selectedYear,selectedMonth,selectedDay) {
//            alert(year);
//            alert(month+1);
//            alert(date);
//            alert((selectedDay+"").length);
            if((selectedDay+"").length==1) {
                selectedDay = "0"+selectedDay;
            }
            if((date+"").length==1) {
                date = "0"+date;
            }
            
            var today = year+""+(month+1)+date;
          //  alert(today);
            var selectedDate = selectedYear+""+selectedMonth+selectedDay;
           // alert(selectedDate);    
            
            if(Number(selectedDate) < Number(today)) {
                alert("오늘보다 이전날짜는 선택 하실 수 없습니다.");
            } else {
            	
                if(confirm("선택하신 날짜가 " +selectedYear +"년" +selectedMonth+"달"+selectedDay+"일 맞습니까?")) {
                	alert("선택하신 날짜로 예약하겠습니다.");	
                	document.getElementById("year").value = selectedYear;
                    document.getElementById("month").value = selectedMonth;
                    document.getElementById("selectedDay").value = selectedDay;
                    document.getElementById("schedule").value = selectedYear+"/"+selectedMonth+"/"+selectedDay;
                    alert( document.getElementById("schedule").value);
                } else {
                		alert("날짜를 다시 선택해 주세요.");	
                }
            }       
            
            //alert(selectedYear);
            //alert(selectedMonth);
            //alert(selectedDay);
        }
    </script>
</html>