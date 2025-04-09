package day08Prac.eljst;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02")
public class Ex02Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//모델
		ArrayList<String> list = new ArrayList<>();
		list.add("아메리카노");
		list.add("카페라뗴");
		list.add("쌍화탕");
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/ex02.jsp").forward(req, resp);
	}
}
