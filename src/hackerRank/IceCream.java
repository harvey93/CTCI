package hackerRank;

import java.util.HashMap;

public class IceCream {

	public static void flavors(int m, int[] a){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < a.length; i++){
			int current = a[i];
			int target = m - current;
			if(map.containsKey(target)){
				System.out.print(map.get(target) + 1 + " ");
				System.out.println(i + 1);
				break;
			}
			map.put(current, i);
		}
	}
}
