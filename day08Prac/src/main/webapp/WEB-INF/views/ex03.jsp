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
	<%
		/*
			jsp에서 사용할 수 있는 저장소 : request, session, application, pageContext
			EL문법은 저장소에 저장된 내용들을 EL문법으로 편하게 가져올 수 있다/
		*/
		
		String str = "el로 출력이 되나요 안되나요 => 저장소에 저장된 것이 아니라면 EL사용 몬함";
		//${str}로 EL문법을 사용해도 출력되지 않는다 ㅇ;유ㅠ는 저장소에 저장된 것이 아니기 때문
		
		pageContext.setAttribute("str", str);
		//pageContext라는 jsp페이지 내에서만 사용하는 저장소에 저장하고 EL사용해보자
		
		
		
	%>
	
	${str }
</body>
</html>