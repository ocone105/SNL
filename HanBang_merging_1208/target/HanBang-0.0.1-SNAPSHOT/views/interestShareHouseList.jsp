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
         <ul>
               <c:if test="${interestShareHouses eq null }">
                  <li>관심하우스로 등록된 셰어하우스가 없습니다.</li>
               </c:if>
               <c:if test = "${interestShareHouses ne null }">
               <c:forEach var="interestHouse"
                     items="${interestShareHouses}" >
                  
                     <li><input type="checkbox"
                        id="interestShareHouseCheck"
                        name="interestShareHouseCheck"> <label
                        class="hide" for="interestShareHouseCheck">셰어하우스
                           삭제</label> <a href="${ctx}/shareHouseDetail.do?="${interestHouse.shareHouseId }>
                           <h4>셰어하우스 : ${interestHouse.title}</h4> 
                          <h4>성별 : ${room.sex }</h4>
                           <h4>${room.deposit } / ${room.monthlyFee }</h4>
                     </a> <a href="${ctx}/questionCreate.jsp" target="_blank">하우스 방문
                           문의</a>
                          
                           <a href="${ctx}/interestShareHouseDelete.do?memberId="${memberId }>삭제</a></li>
                           
                  </c:forEach>
               </c:if>
         </ul>
         <input type="submit" name="interestShareHouseDeleteBtn" value="삭제">
      </form>
   </section>
   </main>

   <%@ include file="/views/layout/footer.jsp"%>

</body>
</html>