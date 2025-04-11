package day03Prac;

import java.util.ArrayList;

public class StarService {
	public ArrayList<String> startower(int stairs) {
	    ArrayList<String> list = new ArrayList<>();
	    for (int i = 1; i <= stairs; i++) {
	        StringBuilder stars = new StringBuilder();
	        for (int j = 0; j < i; j++) {
	            stars.append("*");
	        }
	        list.add(stars.toString() + "<br>");
	    }
	    return list;
	}

	public static void main(String[] args) {
		StarService s = new StarService();
		ArrayList<String> a = s.startower(5);
		for(String b : a) {
			System.err.print(b);
		}
	}
}
