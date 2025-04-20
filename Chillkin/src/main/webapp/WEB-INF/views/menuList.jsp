<%@page import="java.util.ArrayList"%>
<%@page import="branches.Branches"%>
<%@page import="branches.Menu"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/menuList.css">
<script>
function chageSelect(){
	const selectBranch = document.getElementById("selectBox");
    const selectedBranchId = selectBranch.value;
    
    // BranchId 클래스를 가진 모든 input 요소 가져오기
    const branchInputs = document.getElementsByClassName("BranchId");

    // 각각의 input 요소에 선택한 Branch_Id 값 넣기
    for (let i = 0; i < branchInputs.length; i++) {
        branchInputs[i].value = selectedBranchId;
    }
}


</script>
</head>
<body>
<%//#c3292a #fffae5
ArrayList<Branches> bList =(ArrayList<Branches>) request.getAttribute("bList");
ArrayList<Menu> mList =(ArrayList<Menu>) request.getAttribute("mList");
%>

<div class="wrap">
<nav>
<div class="login-link"><a href="/Chillkin/login">가맹점 로그인하기</a></div>

<div class="logo-box">
<img src="<%=request.getContextPath() %>/img/logo.png">
<p class="logo-text">chillkin</p>
</div>

<select id="selectBox" name="Branch_Id" onchange="chageSelect()">
<% for(Branches b :bList){ %>
<option value="<%=b.getBranch_Id() %>"><%=b.getAddress() %>
<%} %>
</select>
</nav>
<div class="menu-wrap">
<ul>

<%
for(Menu m: mList){
%>

<form action="<%=request.getContextPath() %>/order" method="post">
<li>
<div class="img-box"><img src="<%=request.getContextPath() %>/img/<%=m.getMenu_Code() %>.jpg"></div>


<%=m.getMenu_Name() %> <br>
<label>수량: <input type="number" name="O_cnt" min="1" max="99" value="1"> </label>

<input type="hidden"  value="B2222"  name="Branch_Id" class="BranchId"> 
<input type="hidden"  value="<%=m.getMenu_Code() %>"  name="Menu_Code"> 
<button type="submit">주문하기</button></li>
</form>

<%} %>
</ul>
</div>
</div>
</body>
</html>