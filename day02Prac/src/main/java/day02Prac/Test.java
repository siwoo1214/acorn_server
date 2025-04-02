package day02Prac;

public class Test {
	public static void main(String[] args) {
		Movie m = new Movie("안녕 할부지","95분" ,"할부지" );
		
		System.out.println(m.toString());
		
		System.out.println(m.getActor());
		System.out.println(m.getName());
		System.out.println(m.getRunningtime());
	}
}
