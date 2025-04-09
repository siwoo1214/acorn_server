<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
		width: 300px;
		margin: o auto;
		backgroun-color: green;
	}
</style>
</head>
<body>
	<h2>멋있는 뷰</h2>
	
	<% /*String data = (String)request.getAttribute("data"); */%>
	
	<!-- 세션저장소에서 값을 꺼내오기(session내장객체/메소드, 이용하기) -->
	<% String data = (String)session.getAttribute("data"); %>
	
	<div>
		<%=data %>
	</div>
</body>
</html>