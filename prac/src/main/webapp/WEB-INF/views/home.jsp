<%@page import="prac.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트로 출력</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<h2>근데 이제 테이블로 출력을 곁들인</h2>
	<% ArrayList<Acorn> list = (ArrayList<Acorn>)request.getAttribute("list"); %>
	
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
		</tr>
	<% for(Acorn a : list) {%>	
		<tr>
			<td><%=a.getId() %></td>
			<td><%=a.getPw() %></td>
			<td><%=a.getName() %></td>
		</tr>
	<% } %>	
	</table>
	
		
	
</body>
</html>