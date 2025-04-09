package day07Prac.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");  //=> 키의 이름은 form태그의 name기준
		String pw = req.getParameter("pw");
		
		//로그인 성공여부 - 서비스, DAO 필요함
		//But 간단하게 로직을 처리하겠음  id,pw가 같으면 회원으로 인정하겠음
		
		boolean result;
		if(id.equals(pw)) {
			result=true;
		}else {
			result=false;
		}
		
		if(result) { //if(result)와 같음
			//로그인 성공했을 때 기능 구현
			//로그인 성공정보를 세션에 저장할거임
			// 1) 세션저장소 얻어오기  2) 저장하기
			HttpSession session = req.getSession();
			session.setAttribute("loginid", id);
//			session.setAttribute("loginpw", pw);
			
			//메인페이지 요청될 수 있도록 redirect
			resp.sendRedirect("/day07Prac/main");
		} else {
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
	}
}
