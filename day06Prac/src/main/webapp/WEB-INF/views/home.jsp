<%@page import="day06Prac.Exam.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
<link rel="stylesheet" type="text/css" href="css/homeStyle.css">
</head>
<body>
	<% ArrayList<Acorn> list = (ArrayList<Acorn>) request.getAttribute("list"); %>
	<div class="m">
		<h2>근데 이제 테이블로 출력을 곁들인</h2>
	
		<table>
		<tr class="t-head">
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
		</tr>
		
		<% for(Acorn a : list) { %>
		<tr class="t-body">
			<td><%=a.getId() %></td>
			<td><%=a.getPw() %></td>
			<td><%=a.getName() %></td>
		</tr>
		<% } %>
	</table>
	</div>
	
</body>
</html>