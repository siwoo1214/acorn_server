package day03Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/divisor")
public class DivisorServlet  extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		
		//사용자 정보 가져오기  , 어떤 수 가져오기
		//쿼리스트링  ?su=12
		String su_ =  request.getParameter("su");   // "12"
		int su  =  Integer.parseInt(su_);   //12
		
		
		
		//약수를 구한다   12 => 1  2  3  4  6  12 
		//
		ArrayList<Integer> list  = new ArrayList<>();
		for(int i=1 ; i<=su; i++) {
			if( su % i ==0) {
				list.add(i);
			}
		}
		
		
		System.out.println( list);
		
		//응답
		
		PrintWriter   out  = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");		
		out.println("<body>");		
		out.println( list.toString());		
		
		out.println("<body>");
		out.println("</html>");
		
		
	}
}
