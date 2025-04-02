package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sumnums")
public class Prac1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 입력값 받기
        String num1 = req.getParameter("su1");
        String num2 = req.getParameter("su2");

        //오류상황에 대비한 수들의 초기값 설정
        int su1 = 0;
        int su2 = 0;
        boolean validInput = true;
        String errorMessage = "";

        try {
            if (num1 != null && !num1.isEmpty() && num2 != null && !num2.isEmpty()) {
                su1 = Integer.parseInt(num1);
                su2 = Integer.parseInt(num2);
            } else {
                validInput = false;
                errorMessage = "숫자를 입력해주세요.";
            }
        } catch (NumberFormatException e) {
            validInput = false;
            errorMessage = "유효한 숫자를 입력해주세요.";
        }

        // 응답 출력
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<head><title>숫자 사칙연산</title></head>");
        out.print("<body>");
        out.print("<h2>숫자 사칙연산 프로그램</h2>");

        // 입력 폼
        out.print("<form action='/day01Prac/sumnums' method='get'>");
        out.print("첫 번째 숫자: <input type='text' name='su1'><br>");  //근데 su1,2로 받아오니까
        out.print("두 번째 숫자: <input type='text' name='su2'><br>"); //데이터가 삽입되는거임
        out.print("<input type='submit' value='사칙연산'>");
        out.print("</form>");

        // 결과 출력
        if (validInput) {   //만약 유효성 검사를 전부 다 통과했다면
            int sum = su1 + su2;
            int minus = su1 - su2;
            int multi = su1 * su2;
            int devi = su1 / su2;
            out.print("<h3>덧셈 결과: " + su1 + " + " + su2 + " = " + sum + "</h3>");
            System.out.println("두 수의 합: " + sum); 
            
            out.print("<h3>뺼셈 결과: " + su1 + " - " + su2 + " = " + minus + "</h3>");
            System.out.println("두 수의 차: " + minus); 
            
            out.print("<h3>곱셈 결과: " + su1 + " * " + su2 + " = " + multi + "</h3>");
            System.out.println("두 수의 곱: " + multi); 
            
            out.print("<h3>나눗셈 결과: " + su1 + " / " + su2 + " = " +devi + "</h3>");
            System.out.println("두 수의 나누기: " + devi);  
        } else {
            out.print("<p style='color:red;'>" + errorMessage + "</p>");
        }

        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
