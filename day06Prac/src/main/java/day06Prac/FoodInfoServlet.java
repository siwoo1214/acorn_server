package day06Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


// 사용자가 요청시 화면전환없이 받으려면  자바스크립트 라이브러리  jquery의  ajax매서드를 통해서 호출해야 
// 화면전환없이 데이터만 받아올 수 있다 ( 주의 !!  그냥 요청(a 태그)요청 -> 데이터는 오지만, 화면이 바뀐다 )
// 사용자가 음식정보를 요청하면  json 형태의  음식정보 제공하기 
// 클라언트 요청하는 방법  => 자바스크립트로 요청해야함  ( jquery  -> ajax매서드  ) 


@WebServlet("/foodInfo1")
public class FoodInfoServlet  extends HttpServlet{

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 
		 //
		 resp.setCharacterEncoding("utf-8");
		 resp.setContentType("application/json;charset=utf-8");
		 
		 //모델  (음식정보 한 개)
		 Food food  = new Food("육회비빔밥" ,  "13000");
		 
		 
		 // json형태 데이터로 응답
		 
		 //자바  -> json형식
		 
		 JSONObject o = new JSONObject();
		 o.put("name", food.getName()); 
		 o.put("price", food.getPrice());
		 
		 
		 //resp.getWriter().print( food);   // food.toString()
		 
		  resp.getWriter().print( o);   // food.toString()
		 
		 
	 }
}
