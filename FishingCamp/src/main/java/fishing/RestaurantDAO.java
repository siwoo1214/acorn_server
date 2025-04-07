package fishing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestaurantDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	
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
		public ArrayList<Restaurant> selectAll(){
				
				ArrayList<Restaurant> list = new ArrayList<>();
				
				
				//데이터베이스 연결하기
				Connection con = getConnection();
				String sql = "select * from RESTAURANT";
				
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						
						String menu = rs.getString(1);
						int price = rs.getInt(2);
						String description = rs.getString(3);
						String category = rs.getString(4);
						String img_url = rs.getString(5);
						
							
						
						Restaurant restaurant = new Restaurant(menu, price, description, category, img_url);
						list.add(restaurant);
						
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
		public Restaurant selectOne(String menu) {
			
			Connection con = getConnection();
			
			Restaurant restaurant = null;
			
			
			String sql = "select * from RESTAURANT where menu = ?";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, menu);
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					
					String rmenu = rs.getString(1);
					int price =	rs.getInt(2);
					String description = rs.getString(3);
					String category = rs.getString(4);
					String image_url = rs.getString(5);
		            
					restaurant = new Restaurant(rmenu, price, description, category, image_url);
					
				}
				
				
				rs.close();
				pst.close();
				con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return restaurant;
			
			
		}
		
	
	
}
