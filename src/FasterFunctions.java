import java.util.Random;

public class FasterFunctions {
	static Thread a;
	Thread b;
	Thread c;
	
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		a = new Thread(() -> {System.out.println("Starting slowSortLargeArray()...");
		SlowFunctions.slowSortLargeArray();
		System.out.println("slowSortLargeArray() Complete.");
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("slowSortLargeArray() Time: " + endTime + "\n\n");
		} ); 
		
		startTime = System.currentTimeMillis();
		System.out.println("Starting ackermann(3, 14)...");
		System.out.println("ackermann(3, 14): " + SlowFunctions.ackermann(3, 14));
		System.out.println("ackermann(3, 14) Complete.");
		endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("ackerman(3, 14) Time: " + endTime + "\n\n");
		
		System.out.println("Starting millionsOfSqrts()...");
		SlowFunctions.millionsOfSqrts();
		System.out.println("millionsOfSqrts() Complete.");
		endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		
		System.out.println("Total Time: " + totalTime + "\n\n");
			
	}
	public void slowSortLargeArray() {
		final int BIL = 100_000;
		int[] nums = new int[BIL];
		for(int i = 0; i < BIL; i++) {
			nums[i] = new Random().nextInt();
		}
		for(int i = 0; i < BIL - 1; i++) {
			for(int j = i + 1; j < BIL; j++){
				if(nums[i] > nums[j]) {
					int t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		System.out.println("Smallest Value: " + nums[0]);
		System.out.println("Largest Value: " + nums[nums.length - 1]);
	}
	
}
