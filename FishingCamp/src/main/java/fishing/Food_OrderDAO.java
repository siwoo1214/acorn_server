package fishing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Food_OrderDAO {
	
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
		public ArrayList<Food_Order> selectAll(){			
			
				ArrayList<Food_Order> list = new ArrayList<>();
					
					
				//데이터베이스 연결하기
				Connection con = getConnection();
				String sql = "select * from FOOD_ORDER";						
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
						
					while(rs.next()) {
						
						int o_number = rs.getInt(1);
						String a_code = rs.getString(2);
						String menu = rs.getString(3);
						String order_date = rs.getString(4);
						int quantity = rs.getInt(5);
						int total_price = rs.getInt(6);
						
							
								
							
						Food_Order food_order = new Food_Order(o_number, a_code, menu, order_date, quantity, total_price);
						list.add(food_order);
							
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
		
		
		public Food_Order selectOne(String a_code) {
					
					Connection con = getConnection();
					
					Food_Order food_order = null;
					
					
					String sql = "select * from FOOD_ORDER where a_code = ?";
					
					try {
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1, a_code);
						
						ResultSet rs = pst.executeQuery();
						
						if(rs.next()) {
							
							int o_number = rs.getInt(1);
							String oa_code = rs.getString(2);
							String menu = rs.getString(3);
							String order_date = rs.getString(4);
							int quantity = rs.getInt(5);
							int total_price = rs.getInt(6);
				            
							food_order = new Food_Order(o_number, oa_code, menu, order_date, quantity, total_price);
							
						}
						
						
						rs.close();
						pst.close();
						con.close();
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					return food_order;
					
					
				}
		
		
		
	/*
	public static void main(String[] args) {
		Food_OrderDAO fd = new Food_OrderDAO();
		ArrayList<Food_Order> list = fd.selectAll();
		for(Food_Order food_order : list) {
			
			System.out.println(food_order);
			
		}
		
		
		
		
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
