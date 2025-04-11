package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fightingMessage")
public class FirstServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");  //한글인코딩
		response.setContentType("text/html;charset=utf-8");  //서버가 보내는 데이터의 형식이 한글로 해석하라는 뜻
		
		//응답하기,화이팅메세지 응답하기
		String str = "한글인코딩해버리기";
		
		
		
		//응답스트림 얻어오기
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>"+str+"</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
