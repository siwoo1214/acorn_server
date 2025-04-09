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


<% String result  = (String) request.getAttribute("data"); %>
<%=result %>

<h2>EL : 저장소의 값을 편리하게 꺼낼 수 있다.</h2>
<p> 주의사항  : 저장소에 저장된 것들만  EL을 사용할 수 있다.</p>


${data} <br>
<!-- el의 값을 이렇게 꺼내올 수 있다 -->
<!-- request어쩌구 저거를 안해도 되서 무지 편하게 사용할 수 있다 -->

${data}

</body>
</html>