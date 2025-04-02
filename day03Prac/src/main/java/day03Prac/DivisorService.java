package day03Prac;

import java.util.ArrayList;

public class DivisorService {
	
	
	public ArrayList<Integer> getDivisor( int su){
		
		
		ArrayList<Integer> list  = new ArrayList<>();
		
		for( int i=1; i<=su ; i++) {
			if( su %i ==0) {
				list.add(i);
			}
		}		
		
		return list;
		
	}
	
	
	public static void main(String[] args) {
		DivisorService   s = new DivisorService();
		ArrayList<Integer> list = s.getDivisor(12);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println( list.get(i));
		}
		
		
		
		//
		
		
		for( int su  : list) {
			System.out.println( su);
		}
		
	}

}
