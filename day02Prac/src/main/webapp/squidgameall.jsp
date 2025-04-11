<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오징어 게임 전체 명단 출력</title>
<style>
	table{
		border: 1px solid black; margin: 0 auto;
		text-align: center;
	}
	
	.c_name{
		background-color: skyblue;
	}
	
	td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<table>
		<tr class="c_name">
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>생년월일</td>
			<td>포인트</td>
			<td>등급</td>
		</tr>
		
		<%
		Connection con=null;
		Statement st=null;
		ResultSet rs= null;
		String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "1234";
        
        try{
        	Class.forName(driver);
        	con=DriverManager.getConnection(url, user, password);
        	
        	String sql = "select * from member_tbl_11";
        	st=con.createStatement();
        	rs=st.executeQuery(sql);
        	
        	while(rs.next()){
        %>
        <tr>
        	<td><%=rs.getString(1) %></td>
        	<td><%=rs.getString(2) %></td>
        	<td><%=rs.getString(3) %></td>
        	<td><%=rs.getString(4) %></td>
        	<td><%=rs.getString(5) %></td>
        	<td><%=rs.getString(6) %></td>
        	<td><%=rs.getString(7) %></td>
        </tr>
        <%
        	}
        }catch(ClassNotFoundException | SQLException e){
        	e.getMessage();
        }finally{
        	try{
        		if(rs!=null) rs.close();
        		if(st!=null) rs.close();
        		if(con!=null) rs.close();
        	}catch(SQLException e){
        		e.getMessage();
        	}
        }
        %>
        		
        
		
		
	</table>
</body>
</html>