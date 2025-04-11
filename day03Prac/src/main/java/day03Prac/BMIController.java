package day03Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//bmi 계산에 대한 응답하는 서비스
//서블릿  - service 
              // - doGet, doPost 


//bmi계산 화면을 제공 
//bmi 계산한 결과를 제공하는 것 
@WebServlet("/bmiService")
public class BMIController extends HttpServlet {

	//사용자가 요청하는 방법에 따라   doGet이 호출되거나 doPost가 호출될 수 있다.
	//서버입장에서는 제공해주는것 사용자입장에서는 받는것
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		 
		request.getRequestDispatcher("WEB-INF/views/bmiForm.jsp").forward(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String  height_ = request.getParameter("height");
		double  height  = Double.parseDouble(height_);
		
		
		String  weight_ = request.getParameter("weight");
		double  weight  = Double.parseDouble(weight_);
		
		
		
		
		System.out.println(height );		
		System.out.println(weight );
		
		
		
	 
		//모델 ( 데이터 구하기)
		String result  = "정상체중";
		
		
		//저장
		
		request.setAttribute("result", result);
			
	
		//응답 view로 포워드
		request.getRequestDispatcher("WEB-INF/views/bmiResult.jsp").forward(request, response);
		
	}
	
	
}
