package ch8;

public class RecOps {
	
	public static int recMult2(int n1, int n2){
		if(n2 == 1){
			return n1;
		}
		
		if(n2 % 2 == 0){
			int half = recMult2(n1, n2 / 2);
			return half + half;
		}else {
			int half = recMult2(n1, (n2 - 1) / 2);
			return half + half + n1;
		}
	}
	
	public static int recMult(int n1, int n2){
		if(n1 == 0 || n2 == 0){
			return 0;
		}
		
		if(n2 == 1){
			return n1;
		}
		
		return n1 + recMult(n1, n2 - 1);
	
	}

}
