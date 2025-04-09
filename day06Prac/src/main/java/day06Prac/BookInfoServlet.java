package day06Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/bookinfo")
public class BookInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");

		Book book = new Book("Harry Potter",14000,"JK 롤링","Bloomsbury");
		
		JSONObject o = new JSONObject();
		o.put("name", book.getName());
		o.put("price", book.getPrice());
		o.put("author", book.getAuthor());
		o.put("publisher", book.getPublisher());
		
		resp.getWriter().print(o);
		
	}
}
