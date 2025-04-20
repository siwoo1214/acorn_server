<%@page import="branches.Order"%>
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

<% ArrayList<Order> olist = (ArrayList<Order>) request.getAttribute("olist");%>

<table>
<tr>
<td>주문번호</td>
<td>메뉴</td>
<td>수량</td>
<td>주문일자</td>

</tr>

<%for(Order o:olist){ %>
<tr>
<td><%=o.getO_Code() %></td>
<td><%=o.getMenu_name()%></td>
<td><%=o.getO_cnt() %></td>
<td><%=o.getO_Date()%></td>

</tr>
<%} %>
</table>
<a href="/Chillkin/b_main">홈페이지 돌아가기</a>		
   <script src="/Chillkin/js/session-check.js"></script>
</body>
</html>