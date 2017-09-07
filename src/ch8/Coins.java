package ch8;
import java.util.*;

public class Coins {
	
	public static long makeChange(int amount){
		int [] coins = {25, 10, 5, 1};
		HashMap<String, Integer> memo = new HashMap<>();
		return makeChange(coins, amount, 0, memo);
	}
	
	public static long makeChange(int[] coins, int amount, int index, HashMap<String, Integer> memo){
		if(amount == 0){
			return 1;
		}
		
		
		if(index >= coins.length){
			return 0;
		}
		
		String key = amount + "-" + index;
		
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		
		int ways = 0;
		int amountFromCoins = 0;
		
		while(amountFromCoins <= amount){
			int remainder = amount - amountFromCoins;
			ways += makeChange(coins, remainder, index + 1, memo);
			amountFromCoins += coins[index];
		}
		
		memo.put(key, ways);
		return ways;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static long makeChange(int amount){
//		HashMap<String, Integer> map = new HashMap<>();
//		int[] coins = {25, 10, 5, 1};
//		return makeChange(coins, amount, 0, map);
//	}
//	
//	public static long makeChange(int [] coins, int amount, int index, HashMap<String, Integer> map){
//		if(amount == 0){
//			return 1;
//		}
//		
//		if(index >= coins.length){
//			return 0;
//		}
//		
//		String key = amount + "-" + index;
//		if(map.containsKey(key)){
//			return map.get(key);
//		}
//		
//		int amtFromCoins = 0;
//		int ways = 0;
//		
//		while(amtFromCoins <= amount){
//			int rem = amount - amtFromCoins;
//			ways += makeChange(coins, rem, index + 1, map);
//			amtFromCoins += coins[index];
//		}
//		
//		map.put(key, ways);
//		
//		return ways;
//	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static long makeChangeDP (int amount){
		int coins[] = {25, 10, 5, 1};
		HashMap<String, Long> map = new HashMap<>();
		return makeChangeDP(coins, amount, 0, map);

	}
	
	public static long makeChangeDP(int[] coins, int money, int index, HashMap<String, Long> map){
		
		if(money == 0){
			return 1;
		}
		
		if(index >= coins.length){
			return 0;
		}
		
		
		String key = money + "-" + index;
		if(map.containsKey(key)){
			return map.get(key);
		}
		int amountWithCoin = 0;
		long ways = 0;
		while(amountWithCoin <= money){
			
			int remaining = money - amountWithCoin;
			ways += makeChangeDP(coins, remaining, index + 1, map);
			amountWithCoin += coins[index];
		}
		
		map.put(key, ways);
		
		return map.get(key);
	}

	
	
	
	public static long makeChangeHR(int[] coins, int money, int index){
		
		if(money == 0){
			return 1;
		}
		
		if(index >= coins.length){
			return 0;
		}
		
		
		
		int amountWithCoin = 0;
		long ways = 0;
		while(amountWithCoin <= money){
			
			int remaining = money - amountWithCoin;
			ways += makeChangeHR(coins, remaining, index + 1);
			amountWithCoin += coins[index];
		}
		
		return ways;
	}

	
	
}
