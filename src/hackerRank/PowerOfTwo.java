package hackerRank;

public class PowerOfTwo {

	public static boolean isPower(int k){
		
		if(k == 2){
			return true;
		}
		if(k % 2 != 0){
			return false;
		}
		return isPower(k / 2);
		
	}
}
