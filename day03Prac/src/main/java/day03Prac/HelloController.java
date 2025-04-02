package day03Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sayhello")
public class HelloController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String name = req.getParameter("name");
		
		PrintHello h = new PrintHello();
		String name_ = h.sayhello(name);
		System.out.println(name_);
		
		req.setAttribute("yourname", name_);
		req.getRequestDispatcher("WEB-INF/views/helloView.jsp").forward(req, resp);
	}
}
