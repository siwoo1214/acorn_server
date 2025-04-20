package headquerter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReviewService {
	ReviewDAO dao = new ReviewDAO();
	
	public ArrayList<Reviews> getReviewList(){		
		return dao.allReviews();
	}
	
	public JSONArray getJsonArray() {
		ArrayList<Reviews> list = dao.allReviews();
		JSONArray arr = new JSONArray();
		
		System.out.println(list.size());
		
		for( int i=0; i<list.size() ;i++) {	
			Reviews review = list.get(i);
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
			arr.put(o);
		}
		return arr;
	}
	
	public void doAnswer(String r_code, String H_answer) {
		dao.writeAnswer(r_code,H_answer);
	}
	
	public static void main(String[] args) {
		ReviewService service = new ReviewService();
		System.out.println(service.getJsonArray());
	}
}
