package day08Prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	private Connection dbCon() {		
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) { System.out.println("db ok");}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<Member> selectPage(int currentPage){
		int start;
		int end;
		ArrayList<Member> list = new ArrayList<>();
		
		start = (currentPage-1)*2+1;
		end = currentPage*2;
		
		Connection con = dbCon();
		String sql = "select * "
				+ "from "
				+ "(select  rownum num,  m_id, m_pw, m_name , m_tel, m_birthday, m_point , m_grade from member_tbl_11) "
				+ "where num  between  ? and  ?";
		System.out.println("sql : "+sql);
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,start);
			pst.setInt(2,end);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String m_id = rs.getString(2);
				String m_pw = rs.getString(3);
				String m_name = rs.getString(4);
				String m_tel = rs.getString(5);
				String m_birthday = rs.getString(6);
				int m_point= rs.getInt(7);
				//
				String m_grade = rs.getString(8);
				
				Member m = new Member(m_id,m_pw,m_name,m_tel,m_birthday,m_point,m_grade);
				
				list.add(m);
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
	
	public ArrayList<Member> selectAll(){
		ArrayList<Member> list = new ArrayList<>();
		Connection con = dbCon();
		
		String sql = "select * from member_tbl_11";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();  //executeQuery는 selecr문에서만 쓸 수 있다
			
			while(rs.next()){  //쿼리결과 한 행씩 가져오기
				String m_id = rs.getString(1);
				String m_pw = rs.getString(2);
				String m_name = rs.getString(3);
				String m_tel = rs.getString(4);
				String m_birthday = rs.getString(5);
				int m_point= rs.getInt(6);
				//
				String m_grade = rs.getString(7);
				
				Member member = new Member(m_id,m_pw,m_name,m_tel,m_birthday,m_point,m_grade);
				list.add(member);
			}
			
			//마무으리
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int  getTotal(){		
		Connection con = dbCon();
		 int count=0;			 
		 try {			 
			String sql =" select count(*) from member_tbl_11 ";
			PreparedStatement pst  =con.prepareStatement(sql);	
		 
			ResultSet rs  =pst.executeQuery();
			
			if( rs.next()) {
				count = rs.getInt(1);
			}	
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {			 
			e.printStackTrace();
		}	 
		 
		 return count;		
	}
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		dao.dbCon();
//		ArrayList<Member> list = dao.selectPage(1);
//		System.out.println(list);
//		int cnt = dao.getTotal();
//		System.out.println(cnt);
		ArrayList<Member> list = dao.selectAll();
		System.out.println(list);
	}
}
