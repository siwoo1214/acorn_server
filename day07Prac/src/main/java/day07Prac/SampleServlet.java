package day07Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sample")
public class SampleServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터 (모델)
		String data = "sample data!!";
		
		//request라는 저장소를 사용
		//하나의 요청이 발생하면 만들어지고 응답되면 소멸됨
		//req.setAttribute("data", data);
		
		//data를 다른 요청에서도 계속적으로 사용하고 싶으면 
		//req말고 session저장소를 사용할 수 있다
		HttpSession session = req.getSession(); //각 사용자에 맞는 저장소를 제공한다
		session.setAttribute("data", data); //세션에 값 설정 완료
		
		//view가 응답되도록
		//데이터는 forward된 곳 까지는 살아있지만 그 외에 다른곳에서는 사용할 수 없음
		//따라서 다른곳에서 사용하기 위해서는 session을 사용해야함
		req.getRequestDispatcher("WEB-INF/views/sampleView.jsp").forward(req, resp);
	}
}
