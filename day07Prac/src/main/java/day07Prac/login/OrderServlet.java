package day07Prac.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 한 회원만 이 서비스를 제공하려고 한다
		//로그인한 회원은 주문정보를 응답하고
		//로그인하지 않은 회원은 로그인서비스가 요청될 수 있도록 sendRedirect시킨다
		
		//session에 저장한 로그인정보를 얻어와서 로그인 여부를 확인할 수 있다
		HttpSession session = req.getSession();
		String loginid = (String)session.getAttribute("loginid");
		
		if(loginid!=null) {			
			// 모델 (주문정보)
			
			// 모델 얻어오기
			// 모델 저장하기
			String item = "티셔츠 25000원";
			
			req.setAttribute("item", item);
			
			req.getRequestDispatcher("WEB-INF/views/order.jsp").forward(req, resp);
		} else {
			//로그인을 안했구만 로그인이 요청될 수 있도록 redirect시켜준다
			resp.sendRedirect("/day07Prac/login");
		}
		
	}
}
