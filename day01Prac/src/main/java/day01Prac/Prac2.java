package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class Prac2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 파라미터 받기
        String su_ = req.getParameter("su");
        int su = 0;
        try {
            if (su_ != null && !su_.isEmpty()) {
                su = Integer.parseInt(su_);
            }
        } catch (NumberFormatException e) {
            su = 0; // 잘못된 입력 처리
        }

        // HTML 응답 생성
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<body>");
        // 입력 폼 추가
        out.print("<form action='/day01Prac/gugudan' method='get'>");
        out.print("조회할 구구단 단을 입력하셔: ");
        out.print("<input type='text' name='su'>");
        out.print("<input type='submit' value='조회'>");
        out.print("</form>");

        // 구구단 출력
        if (su > 0) {
            out.print("<h1>구구단 " + su + "단</h1>");
            for (int i = 1; i <= 9; i++) {
                out.print("<h1>" + su + " × " + i + " = " + (su * i) + "</h1>");
            }
        }
        out.print("</body>");
        out.print("</html>");
    }
}
