package day03Prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/divisorMVC")
public class DivisorController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		//요청 정보 꺼내기
		
		String su_=request.getParameter("su");
		int su = Integer.parseInt(su_);  // 12
		
		
		// 모델만든기 (데이터만들기)
		DivisorService service = new DivisorService();
		ArrayList<Integer> list= service.getDivisor(su);
		
		System.out.println( list);
		
		
		//응답하기
		request.setAttribute("divisor", list);  //내가 만든 데이터의 이름을 divisor라고 이름을 갖다가 붙이는거임 forward시켜줄라고		
		request.getRequestDispatcher("WEB-INF/views/divisorView.jsp").forward(request, response); //하고 jsp로 보여주기 위해 값을 넘겨줌
		
	}
}
