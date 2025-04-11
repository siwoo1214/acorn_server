package day02Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userlist2")
public class UserList2Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터 만들기
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="1234";
		
		ArrayList<Acorn> list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, password);
//			System.out.println(con);
			if(con!=null) System.out.println("DB ok!");
			
			String sql = "select * from acorntbl2";
			
			Statement st = con.createStatement();   //Statement객체로 받아와야지 실제로 실행하는 실행문으로 받을 수 있음
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				
				Acorn acorn = new Acorn(id,pw,name,point);
				list.add(acorn);
			}
			
			System.out.println(list);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//응답하기
		resp.setCharacterEncoding("utf-8"); //한글 인코딩 설정
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<style>");
		out.print("table{ border:1px solid black; margin: 0 auto; }");
		out.print("td{ border:1px solid black; }");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<td>아이디</td>");
		out.print("<td>비번</td>");
		out.print("<td>이름</td>");
		out.print("<td>포이늩</td>");
		out.print("</tr>");
		for(Acorn a : list) {
			out.print("<tr>");
			out.print("<td>"+a.getId()+" </td>");
			out.print("<td>"+a.getPw()+" </td>");
			out.print("<td>"+a.getName()+" </td>");
			out.print("<td>"+a.getPoint()+" </td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("<html>");
		
		
		out.print("</html>");
	}
}
