package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//원하는 수까지 합 응답하기
@WebServlet("/suAdd")
public class SecondServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		String su_ = request.getParameter("su");  //"5" -> 5 secondservlet을 요청할 때 이 이름으로 요청함
		int su = Integer.parseInt(su_);
		
		int sum=0;
		for(int i=0; i<=su; i++) {
			sum+=i;
		}
		
		System.out.println(sum);
		
		//응답
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>"+sum+"</h1>");
		out.print("<img src=\"/day01Prac/b.jpg\">");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
