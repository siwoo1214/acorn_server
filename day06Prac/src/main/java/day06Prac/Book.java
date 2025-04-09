package day06Prac;

public class Book {
	String name;
	int price;
	String author;
	String publisher;
	
	public Book(String name, int price, String author, String publisher) {
		this.name = name;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}
	
	public Book() {}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + ", author=" + author + ", publisher=" + publisher + "]";
	}
	
	
}
