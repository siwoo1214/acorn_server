<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String animal =  (String)session.getAttribute("animal"); 
		String flower = (String)session.getAttribute("flower");
		
	%>
	
	<h2>설문결과 안내</h2>
	
	동물은 <%=animal %>, 
	꽃은 <%=flower %> 을 좋아하시는군요!
</body>
</html>