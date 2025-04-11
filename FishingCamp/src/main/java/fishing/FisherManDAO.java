package fishing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FisherManDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	
	//데이터베이스 연결매서드
	Connection getConnection(){
			
			Connection con =  null;
			//
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return con;
			
		}
	
	//전체조회
	public ArrayList<FisherMan> selectAll(){
			
			ArrayList<FisherMan> list = new ArrayList<>();
			
			
			//데이터베이스 연결하기
			Connection con = getConnection();
			String sql = "select * from FISHERMAN";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()) {
					
					String a_code = rs.getString(1);
					String id =	rs.getString(2);
					String pw = rs.getString(3);
					String name = rs.getString(4);
					String phone = rs.getString(5);
					String fishes_ = rs.getString(6);
		            int fishes = Integer.parseInt(fishes_);
						
					
					FisherMan fisherman = new FisherMan(a_code, id, pw, name, phone, fishes);
					list.add(fisherman);
					
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
	
	//한개조회
	public FisherMan selectOne(String id) {
		
		Connection con = getConnection();
		
		FisherMan fisherman = null;
		
		
		String sql = "select * from FISHERMAN where id = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				
				String a_code = rs.getString(1);
				String fid =	rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				String phone = rs.getString(5);
				String fishes_ = rs.getString(6);
	            int fishes = Integer.parseInt(fishes_);
	            
				fisherman = new FisherMan(a_code, fid, pw, name, phone, fishes);
				
			}
			
			
			rs.close();
			pst.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return fisherman;
		
		
	}
	
	
	//등록하기
	public void insert(FisherMan fisherman) {
		Connection con = getConnection();
		String sql = "insert into FISHERMAN(a_code, id, pw, name, phone, fishes) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			pst.setString(1, fisherman.getA_code());
			pst.setString(2, fisherman.getId());
			pst.setString(3, fisherman.getPw());
			pst.setString(4, fisherman.getName());
			pst.setString(5, fisherman.getPhone());
			pst.setInt(6, fisherman.getFishes());
			
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//변경하기
	public void update(String id, String newpw) {
			
			Connection con = getConnection();
			
			String sql = "update FISHERMAN set pw =? where id =?";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, newpw);
				pst.setString(2, id);
				
				pst.executeUpdate();
				
				pst.close();
				con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	//삭제하기
	
	public void delete(String id) {
			
			Connection con = getConnection();
			String sql = "delete from FISHERMAN where id = ?";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				pst.executeUpdate();
				
				pst.close();
				con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	
}
