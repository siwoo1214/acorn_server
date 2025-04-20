<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>리뷰 작성</title>
</head>
<body>
<c:if test="${not empty message}">
    <p style="color:green;">${message}</p>
</c:if>
    <h2>문의 작성</h2>
    <form action="${pageContext.request.contextPath}/Review_Write" method="post" accept-charset="UTF-8">
        점포코드: <input type="text" name="R_cityCode"><br><br>
        제목: <input type="text" name="R_title"><br><br>
        상세 내용:<br>
        <textarea name="R_detail" rows="5" cols="40"></textarea><br><br>
        <input type="submit" value="확인">
    </form>
</body>
</html>