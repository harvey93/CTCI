package ch8;

import java.util.Arrays;

public class MatrixProbs {
	
	public static int pathsDP(int [][] matrix) {
		int [][] memo = new int[matrix.length][matrix[0].length];
		
		for(int i = matrix.length - 1; i >= 0; i--) {
			for(int j = matrix[0].length - 1; j >= 0; j--) {
				if(i == matrix.length - 1 && j == matrix[0].length - 1) {
					memo[i][j] = 1;
				}
				
				if(isValid(i + 1, j, matrix)) {
					memo[i][j] += memo[i + 1][j];
				}
				
				if(isValid(i, j + 1, matrix)) {
					memo[i][j] += memo[i][j + 1];
				}
			}
		}
		

		return memo[0][0];
				
	}
	
	public static boolean isValid(int row, int col, int[][] matrix) {
		boolean res = true;
		if(row < 0 || row >= matrix.length) {
			res = false;
		} else if(col < 0 || col >= matrix[0].length) {
			res = false;
		} else if(matrix[row][col] == 0) {
			res = false;
		}
		return res;
	}
	
	public static int pathsMemo(int [][] matrix) {
		int [][] memo = new int[matrix.length][matrix[0].length];
		pathsMemo(matrix, memo, 0, 0);
		return memo[0][0];
	}
	
	public static int pathsMemo(int [][] matrix, int [][] memo, int row, int col) {
		if(matrix[row][col] == 0) {
			return 0;
		}
		
		if(row == matrix.length - 1 && col == matrix[0].length - 1) {
			return 1;
		}
		
		if(memo[row][col] > 0) {
			return memo[row][col];
		}else {
			int paths = 0;
			if(isValid(row + 1, col, matrix)) {
				paths += pathsMemo(matrix, memo, row + 1, col);
			}
			if(isValid(row, col + 1, matrix)) {
				paths += pathsMemo(matrix, memo, row, col + 1);
			}
			memo[row][col] = paths;
			return paths;
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static int pathsDP(int[][] matrix){
//		
//		int[][] memo = new int[matrix.length][matrix[0].length];
//		
//		for(int i = matrix.length - 1; i >= 0; i--){
//			for(int j = matrix[0].length - 1; j >= 0; j--){
//				if(i == matrix.length - 1 && j == matrix[0].length - 1){
//					memo[i][j] = 1;
//				}
//				if(valid(i + 1, j, matrix)){
//					memo[i][j] += memo[i + 1][j];
//				}
//				if(valid(i, j + 1, matrix)){
//					memo[i][j] += memo[i][j + 1];
//				}
//			}
//		}
//		return memo[0][0];
//	}
//	
//
//	public static boolean valid(int row, int col, int[][] matrix){
//		boolean res = true;
//		if(row > matrix.length - 1 || row < 0){
//			res = false;
//		}else if(col > matrix[0].length - 1 || col < 0){
//			res = false;
//		}else if (matrix[row][col] == 0){
//			res = false;
//		}		
//		
//		return res;
//	}
//
//	public static int pathsMemo(int[][] matrix){
//		int[][] memo = new int[matrix.length][matrix[0].length];
//		return pathsMemo(0, 0, matrix, memo);
//	}
//	
//	public static int pathsMemo(int row, int col, int[][] matrix, int[][] memo){
//		if(matrix[row][col] == 0){
//			return 0;
//		}
//		if(row == matrix.length - 1 && col == matrix[0].length - 1){
//			return 1;
//		}
//		if(memo[row][col] > 0){
//			return memo[row][col];
//		}else {
//			int down = 0;
//			int right = 0;
//			if(row + 1 >= 0 && row + 1 < matrix.length){
//				down = pathsMemo(row + 1, col, matrix, memo);
//			}
//			if(col + 1 >= 0 && col + 1 < matrix[0].length){
//				right = pathsMemo(row, col + 1, matrix, memo);
//			}
//			int total = down + right;
//			memo[row][col] = total;
//			return total;
//		}
//		
//	}
}
