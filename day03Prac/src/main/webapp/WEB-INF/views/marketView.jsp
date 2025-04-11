<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String name = (String)request.getAttribute("name"); %>
	<% String age = (String)request.getAttribute("age"); %>
	
	<h2>데이터 찍어보기</h2>
	<%=name %>
	<%=age%>
</body>
</html>