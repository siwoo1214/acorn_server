package day08Prac.eljst;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04")
public class Ex04Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//모델
		
		req.setAttribute("data","hello my name is siwoo");
		req.setAttribute("data","hello my name is siwoo");
		
		req.getRequestDispatcher("WEB-INF/views/ex04.jsp").forward(req, resp);
	}
}
