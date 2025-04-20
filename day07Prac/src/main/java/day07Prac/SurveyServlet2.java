package day07Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Survey2")
public class SurveyServlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String animal = req.getParameter("animal"); //getParameter은 원래 String반환
		
		//세션저장소에 저장하기
		
		// 1) 새션 얻어오기
		HttpSession session = req.getSession();
		
		// 2) 세션 저장하기
		session.setAttribute("animal", animal);
		
		//뷰 응답
		req.getRequestDispatcher("WEB-INF/views/survey2View.jsp").forward(req, resp);
	}
}
