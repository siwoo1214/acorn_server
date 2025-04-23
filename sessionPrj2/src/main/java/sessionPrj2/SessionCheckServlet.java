package sessionPrj2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session-check")
public class SessionCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        if (session == null || session.getAttribute("user") == null) {
          //  out.print("{\"valid\": false}");
        } else {
           // out.print("{\"valid\": true}");
        }
        
       //out.print("{\"valid\": false}");   //세션만료 .html 테스트할 때  => 이 값 사용
       out.print("{\"valid\": true}");  // 세션만료연장.html  테스트 할 때  => 이 값을 사용
        out.flush();
    }
}
