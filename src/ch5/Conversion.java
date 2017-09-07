package ch5;

public class Conversion {
	
	public static int convert(int i, int j){
		int res = 0;
		int a = i ^ j;
		String s = Integer.toBinaryString(a);
		for(int b = 0; b < s.length(); b++){
			if(s.charAt(b) == '1'){
				res++;
			}
		}
		return res;
	}
	public static int convert2(int i, int j){
		int count = 0;
		
		for(int a = i ^ j; a != 0; a = a >> 1){
			count += a & 1;
		}
		return count;
	}

}
