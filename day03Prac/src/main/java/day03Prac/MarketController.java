package day03Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/market")
public class MarketController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String age_ = req.getParameter("age");
		int age = Integer.parseInt(age_);
		
		System.out.println(name);
		System.out.println(age_);
		
		
		
		//
		
		
		req.setAttribute("name", name);
		req.setAttribute("age", age_);
		
		
		req.getRequestDispatcher("WEB-INF/views/marketView.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		resp.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
				
		MarketService m = new MarketService();
		String m_ = m.showAll();
		System.out.println(m_);
		
		req.setAttribute("infoServe", m_);
		req.getRequestDispatcher("WEB-INF/views/market.jsp").forward(req, resp);
	}
	
}
