package day06Prac.Exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcornDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";

	public Connection dbcon() {

		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	
	public ArrayList<Acorn> selectAll(){
		Connection con = dbcon();
		String sql = "select * from acorntbl";
		ArrayList<Acorn> list = new ArrayList<>();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				
				Acorn a = new Acorn(id,pw,name);
				list.add(a);
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		AcornDAO a = new AcornDAO();
		ArrayList<Acorn> list = a.selectAll();
		for(Acorn b : list) {
			System.out.println(b);
		}
//		System.out.println();
//		System.out.println(a.selectOne("sulivun"));
//		System.out.println();
//		Acorn acorn = new Acorn("Faker","qwer","이상혁");
//		a.insertMember(acorn);
	}
}
