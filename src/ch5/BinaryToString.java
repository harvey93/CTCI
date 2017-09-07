package ch5;

public class BinaryToString {
	
	public static String bToString(int n){
		String s = "";
		while(n > 0){
			if(n % 2 == 0){
				s = "0" + s;
			}else {
				s = "1" + s;
			}
			n = n /2;
		}
		return s;
	}
	
	public static String decToBinaryString(double num){
		StringBuilder sb = new StringBuilder(".");
		while(num > 0){
			if(sb.length() > 32){
				
				return "ERROR";
			}
			double r = 2 * num;
			if(r >= 1){
				System.out.println(num);
				sb.append(1);
				num = r - 1;
			}else {
				sb.append(0);
				num = r;
			}
			
		
		}
		return sb.toString();
		
	}
	
//	static String printBinary(double num) {
//		if (num >= 1 || num <= 0) {
//			return "ERROR";
//		}
//		
//		 StringBuilder binary = new StringBuilder();
//		 binary.append(".");
//		 while (num > 0) {
//		 
//		 if (binary.length() >= 32) {
//		 return "ERROR";
//		 }
//		
//		double r = num * 2;
//		if (r >= 1) {
//		binary.append(1);
//		num = r - 1;
//		} else {
//		binary.append(0);
//		num = r;
//		}
//		 }
//		 return binary.toString();
//	}

}
