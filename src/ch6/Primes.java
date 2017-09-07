package ch6;

public class Primes {
	
	public static boolean isPrimeFast(int i){
		boolean[] sieve = primeSieve(i);
		return sieve[i];
	}
	
	public static boolean[] primeSieve(int max){
		boolean flags[] = new boolean[max + 1];
		init(flags);
		int prime = 2;
		
		while(prime <= (int) Math.sqrt(max)){
			crossOffFlags(flags, prime);
			
			prime = getNextPrime(flags, prime);
		}
		return flags;
	}
	
	public static int getNextPrime(boolean[] flags, int prime){
		int i = prime + 1;
		for(;i < flags.length; i++){
			if(flags[i]){
				break;
			}
		}
		return i;
	}
	
	public static void crossOffFlags(boolean[] flags, int prime){
		for(int i = prime * prime; i < flags.length; i+= prime){
				flags[i] = false;
			
		}
	}
	
	public static void init(boolean[] flags){
		
		for(int i = 2; i < flags.length; i++){
			flags[i] = true;
		}
	}
	

	public static boolean isPrime(int n){
		if(n < 2){
			return false;
		}
		boolean res = true;
		int root = (int) Math.sqrt(n);
		for(int i = 2; i <= root; i++){
			if(n % i == 0){
				res = false;
				break;
			}
		}
		return res;
	}
}
