package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원 삭제하는 서비스

//컨트롤러 : 서블릿 get
//모델 : 데이터베이스에서 회원정보가 삭제되게
//뷰 : 삭제 성공되었다 뷰

@WebServlet("/acornDelete")
public class AcornDeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 정보 받아오기
		//쿼리 스트링으로 받아오기 ?id=
		String id = req.getParameter("id");
		
		//모델
		AcornService s = new AcornService();
		s.deleteMember(id);
		
		req.getRequestDispatcher("WEB-INF/views/deleteOk.jsp").forward(req, resp);
		
	}
}
