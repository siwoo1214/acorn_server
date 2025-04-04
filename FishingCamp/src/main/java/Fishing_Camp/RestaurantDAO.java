package Fishing_Camp;

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
               ResultSet rs = pst.executeQuery(sql);
               
               while(rs.next()) {
                  
                  String menu = rs.getString(1);
                  String price_ = rs.getString(2);
                     int price = Integer.parseInt(price_);
//                  String description = rs.getString(3);
//                  String category = rs.getString(4);
//                  String img_url = rs.getString(5);
                  
                     
                  
                  Restaurant restaurant = new Restaurant(menu, price);
                  list.add(restaurant);
                  
               }

               
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            
            return list;
         }
}
