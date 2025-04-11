package day02Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원정보를 응답하기
//    /userInfo?id=sulivun_03
@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터베이스 연동
		//원하는 형식으로 가공해서 응답
		
		String id = req.getParameter("id");
		
		
		resp.setCharacterEncoding("utf-8"); //한글 인코딩 설정
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "1234";
		
		//1. 오라클드라이버 로딩
		try {
		Class.forName(driver);
		
		//2. 데이터베이스 연결하기
		con = DriverManager.getConnection(url,user,password);
		//connection정보를 유지해야함0
		
		//3. sql작성
		String sql = "select * from acorntbl2 where id='"+id+"'";
		
		//4. Statement 객체 얻어오기 (쿼리를 실행하는 명령을 가지고 있음)
		st = con.createStatement();
		rs = st.executeQuery(sql);
		
		//5. ResultSet 객체 얻어오기 (쿼리 실행결과, select 쿼리 결과)
		if(rs.next()) {   //rs에 데이터가 있냐? 있으면 true 없으면 false
			out.print(rs.getString(1)+" ");  //조회된 컬럼중에서 첫번째 컬럼
			out.print(rs.getString(2)+" ");  //조회된 컬럼중에서 두번째 컬럼
			out.println(rs.getString(3));  //조회된 컬럼중에서 세번째 컬럼
			out.println(rs.getString(4));  //조회된 컬럼중에서 네번째 컬럼
			
		}
		
		rs.close(); st.close(); con.close();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
