package ch1;

public class Urlify {

	public static void replace(char [] arr, int trueLength){
		int spaces = countSpaces(arr, trueLength);
		int i = trueLength - 1;
		int j = arr.length - 1;
		while(spaces > 0){
			if(arr[i] == " ".charAt(0)){
				arr[j] = "%".charAt(0);
				arr[j - 1] = "0".charAt(0);
				arr[j - 2] = "2".charAt(0);
				j -= 3;
				spaces--;
			}else {
				arr[j] = arr[i];
				j--;
			}
			i--;
		}
	}
	
	public static int countSpaces(char [] arr, int trueLength){
		int count = 0;
		for(int i = 0; i < trueLength; i++) {
			if(arr[i] == " ".charAt(0)){
				count++;
			}
		}
		return count;
	}
}
