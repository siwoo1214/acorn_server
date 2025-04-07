package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원등록서비스 
//get   :  회원화면보여주기  , a태그 링크로 요청하면  
//post  : 회원정보를 가져와서 데이터베이스 등록하기 


@WebServlet("/regAcorn")
public class AcornRegServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//
		req.getRequestDispatcher("WEB-INF/views/joinForm.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//  한글설정하기 	
		req.setCharacterEncoding("utf-8");
		
		//회원정보 가져오기 
		// form name이름으로 가져와야 한다 !!
		String id  = req.getParameter("id");
		String pw  = req.getParameter("pw");
		String name  = req.getParameter("name");
		
		
		System.out.println( id);
		System.out.println( pw);
		System.out.println( name);

		
		
		// 
		Acorn acorn = new Acorn( id, pw, name);
		System.out.println( acorn);
		
		
		//서비스 
		//모델 ->데이터베이스에 등록하기
		
		AcornService s  = new AcornService();
		s.registerMember(acorn);
		
		
		//응답 
		
//		req.getRequestDispatcher("WEB-INF/views/joinOk.jsp").forward(req, resp);
		
		//브라우저에게 재요청하라는 명령 "/day04Prac/acornlist"매핑된 서비스가 다시 요청됨
		resp.sendRedirect("/day04Prac/acornlist");
		
	}
}
