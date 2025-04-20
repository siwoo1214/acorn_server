package branches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BranchesDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	public Connection dbcon() {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			if (con != null)
				System.out.println("db ok~~");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	
	public boolean checkLogin(String branchId, String pw) {
		Connection con = dbcon();
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


	public ArrayList<Branches> selectBranches() {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from Branches";
		ArrayList<Branches> list = new  ArrayList<>();

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String Branch_Id = rs.getString(1);
				String Pw = rs.getString(2);
				String Address = rs.getString(3);
				String Tel = rs.getString(4);
				
				Branches b = new Branches(Branch_Id, Pw, Address, Tel);
				list.add(b);
			}

			con.close();
			pst.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		BranchesDAO b = new BranchesDAO();
		System.out.println(b.selectBranches());
	}

}
