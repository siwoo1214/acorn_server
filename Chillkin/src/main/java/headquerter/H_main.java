package headquerter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/h_main")
public class H_main extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReviewDAO r = new ReviewDAO();
		ArrayList<Reviews> rlist = r.allReviews();
		
		req.setAttribute("rlist", rlist);
		
		
		req.getRequestDispatcher("WEB-INF/views/h_main.jsp").forward(req, resp);
		
	}
}
