<%@page import="java.util.ArrayList"%>
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
     border:1px solid black;
     text-align: center;
     margin: 0 auto;
     line-height: 200px;
  }

</style>
</head>
<body>
	<h2>별탑</h2>
	<% 
  ArrayList<String> list = (ArrayList<String>) request.getAttribute("myStarTower"); 
  for (String line : list) { 
%>
  <p><%= line %></p>
<% } %>

	
</body>
</html>