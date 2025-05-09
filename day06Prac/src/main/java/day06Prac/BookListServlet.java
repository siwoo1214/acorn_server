package day06Prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		
		ArrayList<Book> list = new ArrayList<>();
		list.add(new Book("오만과 편견", 17000, "제인 오스틴", "펭귄클래식"));
		list.add(new Book("돈키호테", 23000, "미겔 데 세르반테스", "민음사"));
		list.add(new Book("죄와 벌", 21000, "표도르 도스토예프스키", "열린책들"));
		list.add(new Book("레 미제라블", 25000, "빅토르 위고", "민음사"));
		list.add(new Book("변신", 16000, "프란츠 카프카", "더클래식"));
		
		JSONArray arr = new JSONArray();
//		for(int i=0; i<list.size(); i++) {
//			Book b = list.get(i);
//			
//			JSONObject books = new JSONObject();
//			books.put("name",b.getName());
//			books.put("price",b.getPrice());
//			books.put("author",b.getAuthor());
//			books.put("publisher",b.getPublisher());
//			
//			arr.put(books);
//		}
		
		for(Book b : list) {
			
			JSONObject books = new JSONObject();
			books.put("name",b.getName());
			books.put("price",b.getPrice());
			books.put("author",b.getAuthor());
			books.put("publisher",b.getPublisher());
			
			arr.put(books);
		}
		
		resp.getWriter().print(arr);
	}
}
