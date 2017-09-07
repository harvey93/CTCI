package hackerRank;

public class Primes {

	public static boolean isPrime(int n){
		if(n == 1){
			return false;
		}
		boolean isPrime = true;
		for(int i = 2; i <= (int)Math.sqrt(n); i++){
			if(n % i == 0){
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
