package fishing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlatformDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public ArrayList<Flatform> selectAll(){
		ArrayList<Flatform> list = new ArrayList<>();
		
		Connection con = getConnection();
		String sql = "select * from FISHING_FLATFORM";
		
			PreparedStatement pst;
			try {
				pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery(sql);
				
				while(rs.next()) {
					int f_code = rs.getInt(1);
					int price = rs.getInt(1);
					
					Flatform flatform = new Flatform(f_code,price);
					list.add(flatform);
				}
				
				rs.close();
				pst.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
	
	public Flatform selectOne(int s_f_code) {
		Connection con = getConnection();
		Flatform flatform = null;
		
		String sql = "select * from fishing_flatform where f_num = ?";
		
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, s_f_code);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				int new_f_code = rs.getInt(1);
				int price = rs.getInt(2);
				
				flatform = new Flatform(new_f_code,price);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flatform;
	}
	
	public static void main(String[] args) {
		FlatformDAO f = new FlatformDAO();
		//selectAll OK
//		ArrayList<Flatform> newlist = f.selectAll();
//		for(Flatform a : newlist) {
//			System.out.println(a);
//		}
		
		Flatform newflatform = f.selectOne(1004);
		System.out.println(newflatform);
		
	}
}
