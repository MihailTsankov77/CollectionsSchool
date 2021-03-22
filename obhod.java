package test;

import java.util.LinkedList;
import java.util.Timer;

public class obhod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 0; i<50000; i++)
			list.add(i);
		
		 long startTime = System.nanoTime();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
		
		
		 long endTime = System.nanoTime();	
		 System.out.println();
		 
		System.out.println(endTime- startTime);
		
		
		
		
		
		  startTime = System.nanoTime();
		
		  list.forEach((n) -> System.out.print(n));
		  
		  
		  endTime = System.nanoTime();	
		
		  System.out.println();
		  System.out.println(endTime- startTime);
		
	}

}
