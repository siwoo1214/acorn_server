package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/myService")
public class 간단한서비스제공  extends HttpServlet {  //서블릿을 상속받아 서블릿을 만들고 service메소드에 오버라이딩한다
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		response.setContentType("text/html;charset=utf-8");   
		response.setCharacterEncoding("utf-8");  // 응답 결과를  utf-8형식으로 해석하라는 의미
			
		PrintWriter out  = response.getWriter();		//나가는 스트림을 통로로 받아옴
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head> ");
		out.println("<meta charset=\"UTF-8\">");
		out.println( "<title>Insert title here</title> ");
		out.println( "</head> ");
		out.println( "<body>");
		out.println( "<h2>hi my 서비스</h2>" );
		out.println( "<img src=\"/day01/img/b.jpg\">" );
		out.println( "<a href=\"https://www.naver.com/\"> 네이버 </a> ");
		out.println("</body> ");
		out.println("</html> "); 
		
	}
	
}
