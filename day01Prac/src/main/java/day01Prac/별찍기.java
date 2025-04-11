package day01Prac;

public class 별찍기 {
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.println();
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
		}
	}
}
