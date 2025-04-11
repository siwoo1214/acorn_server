package day03Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class MyServlet extends HttpServlet{
	//부모의 서비스는 요청방법 GET/POST냐 에 따라 doGet을 호출하거나 doPost를 호출하게 된다
	
	//url직접 호출
	//a태그로 직접 요청하면 get요청으로 인식한다
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("i got you ");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("POST success");
	}
}
