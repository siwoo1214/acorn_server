<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- /servlet1 서블릿은 get요청만 처리할 수 있다
	post요청을 하게되면 405 : 해당 메소드를 처리할 수 없다 (즉 doPost가 구현이 안되있다)
	 -->
	<form action="/day03Prac/servlet1" method="POST">
		<button>post 요청하기</button>
	</form>
	<!-- post요청은 서버에 사용자의 정보를 등록하거나 변경할 때 사용한다. 많은양의 데이터를 형식에 상관없이 보낼 수 있다. -->
</body>
</html>