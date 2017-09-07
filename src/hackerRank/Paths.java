package hackerRank;

import java.util.HashMap;

public class Paths {
	
	public static int count(int[][] matrix){
		return countDP(matrix);
		
	}
	
	public static int countDP(int [][] matrix){
		int[][] paths = new int[matrix.length][matrix[0].length];
		
		for(int i = matrix.length - 1; i >= 0; i--){
			for(int j = matrix[0].length - 1; j >= 0; j--){
				if(end(i, j, matrix)){
					paths[i][j] = 1;
				}
				if(validPath(i + 1, j, matrix)){
					paths[i][j] += paths[i + 1][j];
				}
				if(validPath(i, j + 1, matrix)){
					paths[i][j] += paths[i][j + 1];
				}
			}
		}
		
		return paths[0][0];
	}
	
	public static int countMemo(int row, int col, int[][] matrix, int[][] paths){
		if(!validPath(row, col, matrix)){
			return 0;
		}
		if(end(row, col, matrix)){
			return 1;
		}
		if(paths[row][col] == 0){
			paths[row][col] = countMemo(row + 1,  col, matrix, paths) + countMemo(row, col + 1, matrix, paths);
		}
		
		return paths[row][col];
		
	}
	
	public static int countRec(int row, int col, int[][] matrix){
		if(!validPath(row, col, matrix)){
			return 0;
		}
		if(end(row, col, matrix)){
			return 1;
		}
		return countRec(row + 1, col, matrix) + countRec(row, col + 1, matrix);
		
	}
	
	public static boolean end(int row, int col, int[][] matrix){
		boolean res = false;
		if(row == matrix.length - 1 && col == matrix[0].length - 1){
			res = true;
		}
			
		return res; 
	}
	
	public static boolean validPath(int row, int col, int[][] matrix){
		boolean res = true;
		if(row > matrix.length - 1 || row < 0){
			res = false;
		}else if(col > matrix[0].length - 1 || col < 0){
			res = false;
		}else if (matrix[row][col] == 0){
			res = false;
		}		
		
		return res;
	}

}
