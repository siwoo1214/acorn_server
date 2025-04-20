<%@page import="branches.Hub"%>
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
 
<%ArrayList<Hub> hlist =(ArrayList<Hub>)request.getAttribute("h_list"); %>
<table>
<tr>
<td>재료명</td>
<td>가격</td>
<td>발주수량</td>
<td></td>
</tr>

<%for(Hub h: hlist){ %>
<form action="<%=request.getContextPath() %>/B_I_Order" method="post">
<tr>
<td><%=h.getName() %></td>
<td><%=h.getPrice() %></td>
<td><input type="number" name="I_Cnt" min="1" max="<%=h.getCnt() %>>" value="1"></td>
<td>
<input type="hidden" value="<%=h.getCode() %>" name="I_Code">

<button>발주</button>


</td>
</tr>
</form>
<%} %>



</table>

</body>
</html>