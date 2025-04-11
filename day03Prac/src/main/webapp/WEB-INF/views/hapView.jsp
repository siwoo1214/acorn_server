<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.box{
	width:200px;
	height: 200px;
	border: 1px solid black;
	text-align: center;
	margin: 0 auto;
	}
</style>
</head>
<body>
<% int sum = (int) request.getAttribute("hap"); %>

<h2>1~10까지의 합</h2>
<div class="box">
	<%=sum %>
</div>
</body>
</html>