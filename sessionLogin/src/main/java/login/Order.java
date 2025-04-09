package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/order")
public class Order  extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//세션 확인 후   주문정보 보여주기 
		//세션이 없다면 로그인이 안된상태로 로그인 화면으로 이동하게 함 
		HttpSession session = request.getSession(); //세션을 받아오고 
		String id  = (String) session.getAttribute("id");  //정보를 받아오기
		
		
		// 로그인 유요성 검사
		if( id != null) {		
			// 해당id의 주문정보 가져오기(dao사용)
			request.getRequestDispatcher("WEB-INF/views/order.jsp").forward(request, response);			
		}
		else {
			
			//로그인 되어있지 않으면 로그인하는 페이지로 redirect
			//로그인처리하는 서블릿 (서비스) 리다이랙트  
			response.sendRedirect("/sessionLogin/login");
		}
		
	}
}
