package acorn;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ServletRequest, ServletResponse  //HttpServletRequest,HttpServletResponse의 부모형이다
// 업캐스팅된 상태로 받는다.
//서블릿을 가기전에 거쳐가는 수문장같은 역할

@WebFilter("*.acorn")  //.앞에는 상관없고 .acorn을 갖고있는 애들 모두 필터에 거른다
public class LoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//다운캐스팅해서 사용해야한다
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//심어놓은거 꺼내기
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		if(id!=null) {  //로그인 되어 있구나 -> 원래 흐름대로 실행될 수 있도록
			//chain.doFilter(request, response => 얘네를 무조건 호출시켜줘야한다
			//그래야지만 원래흐름 bookServlet이 실행된다
			
			//서블릿이 실행되기 전에 수행할 코드는 이거 위에다가 작성하고
			chain.doFilter(request, response);
			//서블릿이 실행된 후 응답되기 전에 수행할 코드를 작성한다 ex)실행되는 시간 구하기
		} else {  //안되어있구나
			//로그인서비스가 요청될 수 있도록 redirect해주기
			String path = req.getContextPath();
			resp.sendRedirect(path+"/login");
		}
		//세션의 로그인 정보값 확인하기
		
		//로그인 되어있는 경우
		
		//로그인 안되어있으면 로그인되게 redirect하기
		
		
	}
}
