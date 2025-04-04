<%@page import="Fishing_Camp.FisherMan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 주문</title>
<link href="css/foodorder.css">
</head>
<body>
	<h2>음식 주문</h2>
	<% ArrayList<FisherMan> list = (ArrayList<FisherMan>)request.getAttribute("list"); %>
	<table>
		<tr>
			<td>메뉴</td>
			<td>가격</td>
			<td>설명</td>
			<td>카테고리</td>
		</tr>
		
		<% for(FisherMan f : list){ %>
			<tr>
				<td><%=f.getName() %></td>
				<td><%=f.getId() %></td>
				<td><a href="/FishingCamp/fisherone?id=<%=f.getId() %>">메뉴주문</a></td>
				<!-- fisherone은 낚시꾼 한명 선택하는 서블릿,해당 id를 갖고있는 사람을 수정함 -->
			</tr>
	</table>
</body>
</html>