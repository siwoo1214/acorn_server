package Fishing_Camp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//낚시꾼 테이블 연결
public class FisherManDAO {
	//연결정보
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	//데이터베이스 연결 메소드
	Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//데이터베이스 전체 조회 메소드
	public ArrayList<FisherMan> selectAll(){
		ArrayList<FisherMan> list = new ArrayList<>();
		
		Connection con = getConnection();
		String sql = "select * from FISHERMAN";
		
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			
			while(rs.next()) {
			    String a_code = rs.getString(1);
			    String id = rs.getString(2);
			    String pw = rs.getString(3);
			    String name = rs.getString(4);
			    String phone = rs.getString(5);
			    String fishes_ = rs.getString(6);
			    int fishes = Integer.parseInt(fishes_);

			    FisherMan fisher = new FisherMan(a_code, id, pw, name, phone, fishes);
			    list.add(fisher);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		FisherManDAO f = new FisherManDAO();
		ArrayList<FisherMan> list = f.selectAll();
		for(FisherMan fm : list) {
			System.out.println(fm);
		}
	}
}
