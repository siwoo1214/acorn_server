package sample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/food2")
public class FoodServlet2  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		resp.setCharacterEncoding("utf-8");
		//json파일로 받아와서 자바스크립트로 변형해서 웹페이지에 띄우겠다
		resp.setContentType("application/json;charset=utf-8");		
		
		Food food = new Food("볶음밥","6000");   //지바객체  -> json객체로 변환 후 응답
		//json : { "key" : "value" } 자바스크립트 객체 표기법
		
		JSONObject  o= new JSONObject();
		o.put("name", food.getName());
		o.put("price", food.getPrice());	
		resp.getWriter().println( o);
		
	}

}
