package day02Prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "1234";
		
		//1. 오라클드라이버 로딩
		Class.forName(driver);
		
		//2. 데이터베이스 연결하기
		con = DriverManager.getConnection(url,user,password);
		//connection정보를 유지해야함0
		
		//3. sql작성
		String sql = "select * from acorntbl2";
		
		//4. Statement 객체 얻어오기 (쿼리를 실행하는 명령을 가지고 있음)
		st = con.createStatement();
		rs = st.executeQuery(sql);
		
		//5. ResultSet 객체 얻어오기 (쿼리 실행결과, select 쿼리 결과)
		while(rs.next()) {   //rs에 데이터가 있냐? 있으면 true 없으면 false
			System.out.print(rs.getString(1)+" ");  //조회된 컬럼중에서 첫번째 컬럼
			System.out.print(rs.getString(2)+" ");  //조회된 컬럼중에서 두번째 컬럼
			System.out.println(rs.getString(3));  //조회된 컬럼중에서 세번째 컬럼
//			System.out.println(rs.getString(4));  //조회된 컬럼중에서 네번째 컬럼
			
		}
		
		rs.close(); st.close(); con.close();
	
	}
}
