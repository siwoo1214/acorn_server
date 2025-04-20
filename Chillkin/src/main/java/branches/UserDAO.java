package branches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	
	private Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) { System.out.println("db ok");}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return con;
		
	}
	
	public void insertUser(String Password, String Address, String Tel) {
		
		Connection con = getConnection();
		String last4 = Tel.substring(Tel.length() - 4);
		String branchId = "B" + last4;
		
		String sql = "INSERT INTO Branches (Branch_Id, Pw, Address, Tel) VALUES (?, ?, ?, ?)";
		
		try {
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, branchId);
			pst.setString(2, Password);
			pst.setString(3, Address);
			pst.setString(4, Tel);
			
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void delete(String branchId) {
			
			Connection con = getConnection();
			String sql = "delete from Branches where branch_id = ?";
			
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, branchId);
				pst.executeUpdate();
				
				pst.close();
				con.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
	
	
	public boolean checkLogin(String branchId, String pw) {
		Connection con = getConnection();
		String sql = "SELECT * FROM Branches WHERE Branch_Id = ? AND Pw = ?";
	    boolean result = false;
	    
	    try {
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, branchId);
	        pst.setString(2, pw);
	        
	        ResultSet rs = pst.executeQuery();

	        result = rs.next();
	        
	        rs.close();
	        pst.close();
	        con.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	
	
	/*
	public static void main(String[] args) {
		
		UserDAO dao = new UserDAO();
		
		
		dao.delete("B8119");
		
		
		
		
		
	}
	*/
	
}
