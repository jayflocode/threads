package mod8b;

import java.util.ArrayList;
import java.util.Random;

public class parallelClass {
	
	private static int arrayCount = 0;

	public static void main(String[] args) {
	
		

		Thread t1 = new Thread (new Runnable()  {

			@Override
			public void run() {
				
				Random rand = new Random();
				
				ArrayList<Integer> array = new ArrayList<>();
				
				
				for (int i = 0; i < 200000000; i++) {
					
					
					array.add(rand.nextInt(10) + 1);
					
					arrayCount = arrayCount + array.get(i);
					
					
				
				}	
				
				
		
			}
	
		});
		
		

		Thread t2 = new Thread (new Runnable()  {

			@Override
			public void run() {
				
				Random rand = new Random();
				
				ArrayList<Integer> array = new ArrayList<>();
				
				
				for (int i = 0; i < 200000000; i++) {
					
					
					array.add(rand.nextInt(10) + 1);
					
					arrayCount = arrayCount + array.get(i);
			
				
				}	
				
			
			}
	
		});
		
		Thread t3 = new Thread (new Runnable()  {

			@Override
			public void run() {
				
				Random rand = new Random();
				
				ArrayList<Integer> array = new ArrayList<>();
				
				
				for (int i = 0; i < 200000000; i++) {
					
					
					array.add(rand.nextInt(10) + 1);
					
					arrayCount = arrayCount + array.get(i);
			
				
				}	
				
			
			}
	
		});
		long start = System.nanoTime();
		t1.start();
		t2.start();
		t3.start();
		long end = System.nanoTime();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is " + arrayCount);
		
		long total = end - start;
		
		System.out.println("Time it has taken for parallel task to load is: " + total + " nanoseconds.");

	}

}
