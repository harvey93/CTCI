package ch1;
import java.util.*;

public class Matrix {
	
	public static void zeroMatrix(Integer[][] arr){
		HashSet<Integer> xCoords = new HashSet<>();
		HashSet<Integer> yCoords = new HashSet<>();
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				if(arr[i][j] == 0){
					xCoords.add(i);
					yCoords.add(j);
				}
			}
		}

		fillZeroes(xCoords, yCoords, arr);

	}
	
	public static void fillZeroes(HashSet<Integer> xCoords,HashSet<Integer> yCoords, Integer[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++){
				if(xCoords.contains(i)){
					arr[i][j] = 0;
				}
				if(yCoords.contains(j)){
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static Integer[][] transpose(Integer[][] arr){
		Integer[][] res = new Integer[arr[0].length][arr.length];
		for(int i = 0; i < arr[0].length; i++){
			for(int j = 0; j < arr.length; j++){
				res[i][j] = arr[j][i];
			}
		}
		return res;
	}
	
	public static Integer[][] rotate(Integer[][] arr){
		Integer[][] res = Matrix.transpose(arr);
		for(Integer[] el : res){
			Matrix.reverse(el);
		}
		return res;
	}
	
	public static void reverse(Integer[] arr){
		int i = 0;
		int j = arr.length - 1;
		while(i < j){
			exch(i, j, arr);
			i++;
			j--;
		}
	}
	
	public static void exch(int i, int j, Integer[] arr){
		Integer temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
