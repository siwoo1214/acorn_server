<%@page import="fishing.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약현황</title>
<style>
	h2{
		text-align: center;	
	}

	table{
		margin: 0 auto;
		text-align: center;
	}
	
	td{
		border: 1px solid black;
	}
	
	.f-tr{
		background-color: skyblue;
	}
</style>
</head>
<body>
	<h2>예약 현황</h2>
	<!-- request 저장소에서 꺼내오기 -->
<% ArrayList<Booking> list = (ArrayList<Booking>)request.getAttribute("list"); %>

	<table>
		<tr class="f-tr">
			<td>예약 코드</td>
			<td>일수</td>
			<td>좌대번호</td>
			<td>주문자 코드</td>
		</tr>
		<% for(Booking books : list){ %>
			<tr>
				<td><%=books.getB_code() %></td>
				<td><%=books.getDays() %></td>
				<td><%=books.getF_num() %></td>
				<td><%=books.getA_code() %></td>
				<td><a href="/fishing/fishingOne?a_code=<%=books.getA_code()%>">tlqkf</a></td>
			</tr>
		<% } %>
 	</table> 	
</body>
</html>