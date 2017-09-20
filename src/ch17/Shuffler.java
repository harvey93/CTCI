package ch17;
import java.util.concurrent.ThreadLocalRandom;;


public class Shuffler {

	public static void shuffle(int [] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int j = rand(i);
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	public static int rand(int max) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, max + 1);
		return randomNum;
	}
}
