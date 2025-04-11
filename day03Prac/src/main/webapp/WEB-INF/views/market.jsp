<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.box{
		 width: 200px;
	     height: 200px;
	     border: 1px solid black;
	     text-align: center;
	     margin: 0 auto;
	     line-height: 200px;
	}
</style>
</head>
<body>
	<h2>테스트용</h2>
	<%String infos = (String)request.getAttribute("infoServe"); %>
	<div class="box">
	<%=infos %>
	</div>
	
	<form action="/day03Prac/market" method="post">
		<input type="text" name="name">
		<input type="text" name="age">
		<button>post 요청하기</button>
	</form>
</body>
</html>