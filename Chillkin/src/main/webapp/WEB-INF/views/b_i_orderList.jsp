
<%@page import="branches.B_I_Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<%ArrayList<B_I_Order> bi_list =(ArrayList<B_I_Order>)request.getAttribute("ordeLlist"); %>
<table>
<tr>
<td>발주코드</td>
<td>발주일자</td>
<td>재료명</td>
<td>발주수량</td>
</tr>

<%for(B_I_Order b: bi_list){ %>

<tr>
<td><%=b.getB_I_Code() %></td>
<td><%=b.getB_I_Date() %></td>
<td><%=b.getI_Name() %></td>
<td><%=b.getI_Cnt() %></td>

</tr>
</form>
<%} %>

</table>
<a href="/Chillkin/b_main">홈페이지 돌아가기</a>	
<script src="/Chillkin/js/session-check.js"></script>
</body>
</html>