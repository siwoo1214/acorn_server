package branches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/B_I_Order")
public class B_I_OrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Service s = new Service();
		ArrayList<Hub> h_list = s.selectHub();
		
		req.setAttribute("h_list", h_list);
		req.getRequestDispatcher("WEB-INF/views/b_i_order.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		String B_Code = (String) session.getAttribute("loginId");  //loginId
		
		System.out.println("dfjfjf=" +   B_Code );

		String I_Code = req.getParameter("I_Code");
		int I_Cnt = Integer.parseInt(req.getParameter("I_Cnt"));
		 
		
 
		
		
		B_I_Order i = new B_I_Order(B_Code, I_Code, I_Cnt);
		
		Service s = new Service();
		
		s.insertBIOrder(i);
		
		resp.sendRedirect(req.getContextPath() + "/B_I_Order");
		System.out.println(B_Code);
		
	}
}
