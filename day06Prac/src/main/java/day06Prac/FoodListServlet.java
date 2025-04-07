package day06Prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

//음식정보 여러개를 json으로 응답하기
//클라리언트가 ajax를 통해서 호출해서 화면전환없이 데이터만 가져온다
@WebServlet("/foodDataList")
public class FoodListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		//요청이 오면 
		
		//모델 (음식정보 여러개 : ArrayList<Food>)
		ArrayList<Food> list = new ArrayList<>();
		list.add(new Food("김밥","5500"));
		list.add(new Food("라면","2500"));
		list.add(new Food("떡볶이","6000"));
		
		//json 변환하기, json array 변환
		//라이브러리를 사용
		JSONArray arr = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			Food food = list.get(i);
			
			JSONObject foodO = new JSONObject();
			foodO.put("name", food.getName());
			foodO.put("price", food.getPrice());
			
			arr.put(foodO);
		}
		
		//응답하기 (json변환 한 다음)
//		resp.getWriter().print(list);
		resp.getWriter().print(arr);
	}
}
