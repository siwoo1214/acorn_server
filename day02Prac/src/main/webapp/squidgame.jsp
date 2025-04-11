<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<style>
    table { border: 1px solid black; margin: 0 auto; }
    td { border: 1px solid black; padding: 5px; }
    th { background-color: #f0f0f0; padding: 5px; }
</style>
</head>
<body>
    <table>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>등급</th>
        </tr>
        <%
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "1234";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM member_tbl_11";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
        %>
                <tr>
                    <td><%=rs.getString(1) %></td>
                    <td><%=rs.getString(3) %></td>
                    <td><%=rs.getString(4) %></td>
                    <td><%=rs.getString(7) %></td>
                </tr>
        <%
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        %>
    </table>
</body>
</html>
