<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- request저장소에 있는 키의 이름 list 꺼내와서 item변수명으로 사용하겠다 -->
	<a:forEach var="item" items="${list}">  
		${item.m_id} ${item.m_name} ${item.m_point }<br>
	</a:forEach>
</body>
</html>