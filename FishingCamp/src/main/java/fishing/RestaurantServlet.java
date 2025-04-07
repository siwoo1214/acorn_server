package fishing;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menuall")
public class RestaurantServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAO r = new RestaurantDAO();
		
		ArrayList<Restaurant> list = r.selectAll();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("WEB-INF/views/restaurant.jsp").forward(req, resp);
		
	}
}
