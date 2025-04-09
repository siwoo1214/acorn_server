package day06Prac;

public class ReviewService {
	
	ReviewDAO dao = new ReviewDAO();
	
	
	// 리뷰 등록 하기 
	public  int  registerReview( Review review) {		
		//
		int cnt  =dao.insertReview(review);		
		return cnt;
		
		
	}

}
