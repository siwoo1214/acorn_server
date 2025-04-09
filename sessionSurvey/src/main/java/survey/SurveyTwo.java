package survey;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/survey2")
public class SurveyTwo  extends HttpServlet{
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
	
	 String animal = req.getParameter("animal");
	 
	 //세션에 저장하기
	 HttpSession session  =req.getSession();
	 session.setAttribute("animal", animal);
	//세션에다가 값을 저장해놓는거임 다른데서도 사용할 수 있도록
	 
	req.getRequestDispatcher("WEB-INF/views/survey2.jsp").forward(req, resp);
}
}
