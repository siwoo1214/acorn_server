<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>당신이 좋아하는 것은</h2>

	<!-- session.getAttribute()이거로 세션 받아와서 거기다가 저장하는거임 -->
 <% String animal = (String) session.getAttribute("animal");
    String flower = (String) session.getAttribute("flower"); 
 %>
 
 
  동물은<%=animal %>
  꽃은 <%=flower %>  입니다. 

</body>
</html>