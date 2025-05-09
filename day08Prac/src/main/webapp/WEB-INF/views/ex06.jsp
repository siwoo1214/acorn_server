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
	<h2>1부터 10 출력하기</h2>
	
	<!-- out.print() -->
	<% for(int i=1; i<=10; i++){ %>
		<p><%=i %></p>
	<% }%>
	
	<h2>JSTL 사용하기</h2>
	<c:forEach var="i" begin="1" end="10">
		${i}
	</c:forEach>
	
	<h2>2단 출력하기</h2>
	<c:forEach var="i" begin="1" end="9">
		2 * ${i} = ${2*i}
	</c:forEach>
</body>
</html>