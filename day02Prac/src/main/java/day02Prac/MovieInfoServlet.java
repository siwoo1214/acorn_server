package day02Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//영화정보를 응답하는 서블릿
/*
 String name;
 String runningtime;
 String actor;
*/

@WebServlet("/movieInfo")
public class MovieInfoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8"); //한글 인코딩 설정
		resp.setContentType("text/html;charset=utf-8");
		//내가 서비스 할 내용
		Movie m = new Movie("안녕 할부지","95분" ,"할부지" );
		
		PrintWriter out = resp.getWriter();
		
		// => jsp
		out.print("<html>");
		out.print("<head>");
		
		out.print("<style>");
		out.print("table,td{ border:1px solid black }");		
		out.print("</style>");

		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		
		out.print("<tr>");
		
		out.print("<td>영화이름"); out.print("</td>");
		out.print("<td>러닝타임");out.print("</td>");
		out.print("<td>주연배우");out.print("</td>");
		
		out.print("<tr>");
		
		out.print("<tr>");
		
		out.print("<td>"+m.getName()+"</td>");
		out.print("<td>"+m.getRunningtime()+"</td>");
		out.print("<td>"+m.getActor()+"</td>");
		
			
		out.print("</tr>");
		
		out.print("</table>");		
		out.print("</body>");
		out.print("</html>");
	}
}
