package fishing;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookinglist")
public class BookingList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookingDAO r = new BookingDAO();
		
		ArrayList<Booking> list = r.selectAll();
		
		req.setAttribute("list", list);	
		req.getRequestDispatcher("WEB-INF/views/bookinglist.jsp").forward(req, resp);
	}
}
