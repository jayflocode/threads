package mod8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConClass extends Thread {
	
	int arrayCount = 0;
	
	

	@Override
	public void run() {
		
		long start = System.nanoTime();
		
		Random rand = new Random();
		
		ArrayList<Integer> array = new ArrayList<>();
		
		
		for (int i = 0; i < 200000000; i++) {
			
			
			array.add(rand.nextInt(10) + 1);
			
			arrayCount = arrayCount + array.get(i);
		
		}
		
		long end = System.nanoTime();
		
		System.out.println("Count is " + arrayCount);
		
		long total = end - start;
		
		System.out.println("Concurrent Thread has taken a total of \"" + total + "\" nanoseconds to process.");
		
	}
	


}
