<%@page import="java.util.ArrayList"%>
<%@page import="headquerter.Reviews"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>ChillKin 콤파니</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Chillkin/css/main.css">
</head>
<body>
<% ArrayList<Reviews> rlist = (ArrayList<Reviews>)request.getAttribute("rlist"); %>
<div class="container">
    <div class="sidebar">
        <div class="logo-row">
            <img src="${pageContext.request.contextPath}/img/logo.png" alt="logo">
            <span class="logo-title">ChillKin 콤파니</span>
        </div>
        <div class="sidebar-menu">
            <div><a href="/Chillkin/h_stockmanage">창고 재고 관리</a></div>
            <div><a href="/Chillkin/h_orderingInfo">발주 정보</a></div>
            <div><a href="/Chillkin/h_branchesInfo">가맹점 관리</a></div>
            <div><a href="/Chillkin/reviewPrint">문의접수 목록</a></div>
        </div>
        <img class="chicken-img" src="${pageContext.request.contextPath}/img/chillkinguy.png" alt="chicken">
    </div>
    <div class="main">
        <div class="title">가맹점 문의함</div>
        <!--(for 문으로 db 출력)-->
        <div class ="notice-container">
        <%for (Reviews r : rlist){  %>
        <div class="notice-box">
            <table class="notice-table">
                <tr>
                    <th>접수번호</th>
                    <td><%=r.getR_code() %></td>
                </tr>
                <tr>
                    <th>접수 지점 코드</th>
                    <td><%=r.getId() %></td>
                </tr>
                <tr>
                    <th>접수 일자</th>
                    <td><%=r.getR_date() %></td>
                </tr>
                <tr>
                    <td colspan="2" style="padding-top:10px; font-size:14.5px;">
                        <%=r.getTitle() %>
                    </td>
                </tr>
            </table>
            <div class="notice-bottom"><a href="/Chillkin/answer123?r_code=<%= r.getR_code() %>">답변하기</a></div>
            </div>
            <% }%>
        </div>
    </div>
</div>
</body>
</html>