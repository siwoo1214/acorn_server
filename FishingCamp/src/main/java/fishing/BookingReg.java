package fishing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insertbooking")
public class BookingReg extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/booking.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//한글설정하기 	
			req.setCharacterEncoding("utf-8");
			
			//회원정보 가져오기 
			String a_code = req.getParameter("a_code");
			String days_ = req.getParameter("days");
			int days = Integer.parseInt(days_);
			
			// 임시로 데이터 이거 받아와서 넣어야하는데 해결해야함
			Booking booking = new Booking("B001",days,1001,a_code);
			
			BookingDAO b  = new BookingDAO();
			b.insertBooking(booking);
			
			//응답 
			
			//req.getRequestDispatcher("WEB-INF/views/joinOk.jsp").forward(req, resp);
			
			//브라우저에게 재요청하라는 명령 "/day04Prac/acornlist"매핑된 서비스가 다시 요청됨
			resp.sendRedirect("/fishing/bookinglist");
	}
}
