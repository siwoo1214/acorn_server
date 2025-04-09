<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${data}
	
	<!-- jsp에서 사용할 수 있는 저장소 : pageContext(jsp내에 있는 저장소, request, application, session -->
	<!-- 저장소를 전부 다 뒤진다 (pageContext부터 -->
	<!-- 저장된 값을 가져올 때 모든 저장소를 다 확인함, But 순서가 있음 -->
	<!-- pageContext -> request -> session -> application -->
	
	<%
		pageContext.setAttribute("id", "id pageContext");
		request.setAttribute("id", "id request");
		session.setAttribute("id", "id session");
		application.setAttribute("id", "id application");
		
	%>
	
	${id}
	<!-- scope를 부여해서 구체적인 변수를 불러온다 -->
	${sessionScope.id}
	${requestScope.id}
	${applicationScope.id}
	${pageScope.id}
</body>
</html>