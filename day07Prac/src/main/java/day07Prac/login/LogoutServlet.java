package day07Prac.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logOut")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();  //사용자에 대한 세션저장소에 있는 값 모두 삭제하기
		//session.removeAttribute("as");
		
		//메인페이지가 요청될 수 있도록 하기
		//redirect하기
		
		resp.sendRedirect("/day07Prac/main");
	}
}
