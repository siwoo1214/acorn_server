package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		String pw= req.getParameter("pw");
		
		HttpSession session  =req.getSession();
		if( id.equals(pw)) {
			session.setAttribute("id", id); //아이디 비번 같으면 세션에 담기
			resp.sendRedirect("/loginEL/home");
		}else {
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}		 
	}
}
