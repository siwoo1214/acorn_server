package headquerter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReviewDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String password = "1234";
	
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
	
	public ArrayList<Reviews> allReviews(){
		ArrayList<Reviews> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from Reviews";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String r_code = rs.getString(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String detail = rs.getString(5);
				String r_date = rs.getString(4);
				String answer = rs.getString(6);
				
				list.add(new Reviews(r_code,id,title,detail,r_date, answer)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//얘가 지금 하던거임 04/16버전
	public void writeAnswer(String r_code, String H_answer) {
		Reviews thatReview = null;
		ReviewDAO a = new ReviewDAO();
		ArrayList<Reviews> list = a.allReviews();
		for(Reviews b : list) {
			if(r_code.equals(b.getR_code())) {
				thatReview = b;
			}
		}
		
		Connection con = dbCon();
		String sql = "UPDATE Reviews\r\n"
				+ "SET ANSWER = ? \r\n"
				+ "WHERE R_CODE = ? ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, H_answer);
			pst.setString(2, thatReview.getR_code());
			pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JSONArray selectPage(int currentPage) {
		ReviewDAO r = new ReviewDAO();
		int start;
		int end;
		ArrayList<Reviews> reviewList = r.allReviews();
		JSONArray list = new JSONArray();
		
		start = (currentPage-1)*2+1;
		end = currentPage*2;
		
		Connection con = dbCon();
		String sql = "select * "
				+ "from reviews"
				+ "(select rownum num,r_code,id,title,detail,answer,r_date) "
				+ "where num  between  ? and  ?";
		System.out.println("sql : "+sql);
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,start);
			pst.setInt(2,end);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String r_code = rs.getString(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				String detail = rs.getString(5);
				String r_date = rs.getString(4);
				String answer = rs.getString(6);
				
				Reviews m = new Reviews(r_code,id,title,detail,answer,r_date);
				
				for(int i=0; i<reviewList.size(); i++) {
					Reviews review = reviewList.get(i);
					JSONObject o = new JSONObject();
					o.put("R_CODE", review.getR_code());
					o.put("ID", review.getId());
					o.put("Title", review.getTitle());
					o.put("Detail", review.getDetail());
					if(review.getAnswer()!=null) {
						o.put("Answer", review.getAnswer());
					}else {
						review.answer=null;
					}
					o.put("R_DATE",review.getR_date());
					list.put(o);
				}
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
	
	public List<Reviews> getPagedList(PagingVO paging){
		List<Reviews> pagelist = new ArrayList<>();
		ReviewDAO dao = new ReviewDAO();
		String sql = "select *"
				+ "from (select rownum rn,"
				+ "                a.*"
				+ "        from (select *"
				+ "            from reviews"
				+ "            order by r_code  asc ) a)"
				+ "            where rn > ? and rn <=? ";
		
		try (Connection con = dao.dbCon();
			 PreparedStatement pst = con.prepareStatement(sql)){
			
			pst.setInt(1, paging.getFirstRow());
			pst.setInt(2, paging.getLastRow());
			
			try(ResultSet rs = pst.executeQuery()){
				System.out.println("쿼리 실행 완료" + rs.getRow());
				while(rs.next()) {
					Reviews reviews = new Reviews();
					
					String r_code = rs.getString(1);
		            String id = rs.getString(2);
		            String title = rs.getString(3);
		            String detail = rs.getString(5);
		            String r_date = rs.getString(4);
		            String answer = rs.getString(6);
					
					reviews.setR_Code(rs.getString(1));
					reviews.setId(rs.getString(2));
					reviews.setTitle(rs.getString(3));
					reviews.setDetail(rs.getString(5));
					reviews.setR_Date(rs.getString(4));
					reviews.setAnswer(rs.getString(6));	
					
					pagelist.add(reviews);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리뷰 개수: " + pagelist.size());
		System.out.println("firstRow: " + paging.getFirstRow());
		System.out.println("lastRow: " + paging.getLastRow());
		return pagelist;
	}
	
	public int getTotalCount() {
		String sql = "select Count(*) from reviews";
		ReviewDAO dao = new ReviewDAO();
		
		Connection con = dao.dbCon();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		ReviewDAO a = new ReviewDAO();
		ArrayList<Reviews> list = a.allReviews();
		for(Reviews b : list) {
			System.out.println(b);
		}
//		a.writeAnswer(null, null);
//		String r_code = "R0001";
//		a.writeAnswer(r_code, "dkssudgktpdy rkatkgkqsl;ek");
	}
}
