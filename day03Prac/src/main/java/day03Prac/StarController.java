package day03Prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/startower")
public class StarController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int su = Integer.parseInt(req.getParameter("su"));
//		String su_=req.getParameter("su");
//		int su = Integer.parseInt(su_); 
		
		StarService s = new StarService();
		ArrayList<String> tower = s.startower(su);
		
		req.setAttribute("myStarTower", tower);
		req.getRequestDispatcher("WEB-INF/views/starView.jsp").forward(req, resp);
	}
}
