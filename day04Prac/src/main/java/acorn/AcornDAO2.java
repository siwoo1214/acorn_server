package acorn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcornDAO2 {
	//연결정보
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";
	
	//데이터베이스 연결 메소드
	Connection getConnection(){
		Connection con =null;
		
		//
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password); //연결정보를 con이라는 connection객체로 받아옴
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	//조회하기
	public ArrayList<Acorn> selectAll(){
		ArrayList<Acorn> list = new ArrayList<>();
		//데이터베이스 연결하기
		Connection con = getConnection();
		String sql = "select * from acorntbl";  //DBeaver에서 작성한 복잡한 sql을 삽입하는것임
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			
			while(rs.next()) {  //쿼리의 결과를 한 행씩 가져오기 있을떄 까지
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				
				Acorn acorn = new Acorn(id,pw,name);
				list.add(acorn);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //이래야지만 sql을 사용할 준비가 되었다는 말씀
		
		
		return list;
	}
	
	//한 개 조회
	public Acorn selectOne(String id) {
		//디비 연결
		Connection con = getConnection();
		Acorn acorn = null;
		
		//sql작성
		String sql = "select * from acorntbl where id=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);  //몇번째 물음표니? 하고 물음표에 값 설정해주기
			ResultSet rs = pst.executeQuery(sql);
			
			if(rs.next()) {
				String tid = rs.getString(1);
				String tpw = rs.getString(2);
				String tname = rs.getString(3);
				
				acorn = new Acorn(tid,tpw,tname);
			}
			
			//마무리
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//실행결과 Acorn객체반환
		
		return acorn;
		
		
	}
	
	//등록하기
	public void insert(Acorn acorn) {
		Connection con = getConnection();
		String sql = "insert into acorntbl(id,pw,name) values(?,?,?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			//왼쪽 물음표부터 채운다
			pst.setString(1, acorn.getId());
			pst.setString(2, acorn.getPw());
			pst.setString(3, acorn.getName());
			
			//insert쿼리를 실행해 주세요
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//변경하기
	public void update(String id, String newpw) {
		Connection con = getConnection();
		String sql = "update acorntbl set pw =? where id=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, newpw); //왼쪽 물음표부터 채워야함
			pst.setString(2, id);
			pst.executeUpdate(); //등록,변경,삭제
			
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
		String sql = "delete from acorntbl where id=?";
		
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
	
	public static void main(String[] args) {
		/*
		AcornDAO2 s = new AcornDAO2();
		ArrayList<Acorn> list = s.selectAll();
		for(Acorn acorn : list) {
			System.out.println(acorn);
		}
		*/
		
//		AcornDAO2 s = new AcornDAO2();
//		Acorn a = s.selectOne("hong3");
//		System.out.println(a);
		
		
//		AcornDAO2 s = new AcornDAO2();
//		Acorn acorn = new Acorn("hong3","1234","최완빈");
//		s.insert(acorn);
		
//		AcornDAO2 a = new AcornDAO2();
//		a.update("hong3", "9999");
		
		//삭제
		AcornDAO2 a = new AcornDAO2();
		a.delete("hong3");
	}
}
