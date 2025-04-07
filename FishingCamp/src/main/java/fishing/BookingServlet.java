package fishing;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/booking")
public class BookingServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookingDAO r = new BookingDAO();
		
		ArrayList<Booking> list = r.selectAll();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/bookinglist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String b_code = req.getParameter("b_code");
		String days_ = req.getParameter("days");
		int days = Integer.parseInt(days_);
		String f_num_ = req.getParameter("f_num"); 
		int f_num = Integer.parseInt(f_num_);
		String a_code = req.getParameter("a_code"); 
		
		//예약하기
		BookingDAO b = new BookingDAO();
		Booking booking = new Booking(b_code,days,f_num,a_code);
		b.insertBooking(booking);
		
		//응답
		//변경 완료
		resp.sendRedirect("WEB-INF/views/bookinglist.jsp");
	}
}
