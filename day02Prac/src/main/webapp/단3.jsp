<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사칙연산</title>
    <link rel="icon" type="image/x-icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfWHSnzZvwAYmbWVcTnRlvb4mvMLfGSCAV4Q&s">
</head>

<body>
<!--  request, response, out 얘네는 그냥 갖다가 쓸 수 있음 -->
<%
String total="";
for(int i=1; i<10; i++){
	total += "3 x "+i+" = " + (3*i)+"<br>";
}
%>
<h1>3단</h1>
<p><%=total %></p>
<%out.println(total); %>
</body>
</html>