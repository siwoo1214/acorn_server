<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
<style>
	a{
		color:black;
	}
</style>
</head>
<body>
	<h2>메인페이지</h2>
	
	<!-- 로그인 여부에 따라 다르게 보일 수 있도록 -->
	<!-- 세션저장소에 로그인정보를 확인하고 로그인 상태인지 확인할 수 있다 -->
	
	<% String loginid = (String)session.getAttribute("loginid"); %>
	
	<% if(loginid != null){ %>
		<strong><%=loginid %></strong>님 반갑습니다!
		<a href="/day07Prac/logOut">로그아웃</a>
		<a href="/day07Prac/order">상품주문정보</a>
	<% }else{ %>
		<a href="/day07Prac/login">로그인</a>
		<a href="/day07Prac/order">상품주문정보</a>
	<% } %>
</body>
</html>