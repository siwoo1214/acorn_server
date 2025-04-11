<%@page import="fishing.Restaurant"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<form action="/fishing/foodorder" method="post">
<% ArrayList<Restaurant> list = (ArrayList<Restaurant>)request.getAttribute("list"); %>

<table>

<tr>
<td>메뉴</td>
<td>가격</td>
<td>음식소개</td>
<td>카테고리</td>
</tr>

<% for(Restaurant r : list){ %>
<tr>
<td><%=r.getMenu() %></td>
<td><%=r.getPrice() %></td>
<td><%=r.getDescription() %></td>
<td><%=r.getCategory() %></td>
<td><a href="">주문</a></td>
</tr>
<%} %>

</table>

</form>



</body>
</html>