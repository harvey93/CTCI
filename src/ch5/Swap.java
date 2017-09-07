package ch5;

public class Swap {
	
	public static int swap(int i){
		int x = 0xaaaaaa;
		int odds = i & x;
		int y = 0x5555555;
		int evens = i & y;
		
		
		return (odds >> 1) | (evens << 1);
	}

}
