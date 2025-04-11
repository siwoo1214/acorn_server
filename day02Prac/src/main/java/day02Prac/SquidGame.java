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

@WebServlet("/squidgamelist")
public class SquidGame extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="1234";
		
		ArrayList<SquidGameMembers> list = new ArrayList<>();
		
		try {
			Class.forName(driver);  //DB드라이버 로드
			Connection con = DriverManager.getConnection(url,user,password); //DB연결
			
			if(con!=null) System.out.println("DB ok입니다~");
			
			String sql = "select * from member_tbl_11";
			
			//SQL 실행문
			Statement st = con.createStatement();  //그니까 Statement로 받아서
			ResultSet rs = st.executeQuery(sql);  //실행된 결과를 rs에다가 저장하는거임
			
			//rs의 값이 있으면 계속 받아오고 없으면 끝나는 while문
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(3);
				String phone = rs.getString(4);
				String grade = rs.getString(7);
				
				SquidGameMembers sm = new SquidGameMembers(id,name,phone,grade);
				list.add(sm);
			}
			
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
		out.print("<td>포인트</td>");
		out.print("</tr>");
		for(SquidGameMembers a : list) {
			out.print("<tr>");
			out.print("<td>"+a.getId()+" </td>");
			out.print("<td>"+a.getName()+" </td>");
			out.print("<td>"+a.getPhone()+" </td>");
			out.print("<td>"+a.getPoint()+" </td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("<html>");
		
		
		out.print("</html>");
	}
}
