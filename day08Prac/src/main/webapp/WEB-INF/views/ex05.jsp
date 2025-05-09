<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>El, JSTL, 단순IF, Choose문 사용하기</h2>
	
	<% request.setAttribute("kor", 80); %>
	<!-- 조건 만족하면 안에 문장 실행 -->
	<c:if test="${kor>=90}">
		[장학금 지급]
	</c:if>
	
	
	<% int score =  (int)request.getAttribute("kor"); 
		if(score>=90){%>
			<p>[장학금 지급]</p>
		<%} %>
	
	<!-- jstl로 변수만들기 -->
	<!-- jstl 변수 자동으로 pageContext저장소에 저장됨, 즉 EL문법을 사용할 수 있다 -->
	<c:set var="test" value="testdata"></c:set>
	
	<h2>test변수의 결과 EL출력하기</h2>
	${test }
	
	<h4>여러 조건을 수행하는 구문</h4>
	<c:choose>
		<c:when test="${kor>=90}">수</c:when>
		<c:when test="${kor>=80}">우</c:when>
		<c:when test="${kor>=70 }">미</c:when>
		<c:otherwise>가</c:otherwise>
	</c:choose>
</body>
</html>