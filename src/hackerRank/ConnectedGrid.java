package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class ConnectedGrid {
	
	public static int regionGrid(int[][] matrix, int m, int n){
		int max = 0;
		
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				max = Math.max(max, getCountsBFS(matrix, i, j));
			}
		}
		return max;
	}
	
	public static int getCountsBFS(int [][] matrix, int i, int j){
		int count = 0;
		if(matrix[i][j] == 0){
			return count;
		}
		LinkedList<ArrayList<Integer>> queue = new LinkedList<>();
		queue.add(new ArrayList<Integer>(Arrays.asList(i,j)));
		while(!queue.isEmpty()){
			ArrayList<Integer> currentList = queue.removeFirst();
			int currentRow = currentList.get(0);
			int currentCol = currentList.get(1);
			if(currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[0].length){
				int currentVal = matrix[currentRow][currentCol]--;  
				if(currentVal == 1){
					count++;
					queue.add(new ArrayList<Integer>(Arrays.asList(currentRow + 1, currentCol)));
					queue.add(new ArrayList<Integer>(Arrays.asList(currentRow - 1, currentCol)));
					queue.add(new ArrayList<Integer>(Arrays.asList(currentRow, currentCol + 1)));
					queue.add(new ArrayList<Integer>(Arrays.asList(currentRow, currentCol - 1)));
					
					queue.add(new ArrayList<Integer>(Arrays.asList(currentRow + 1, currentCol + 1)));
					queue.add(new ArrayList<Integer>(Arrays.asList(currentRow + 1, currentCol - 1)));
					
					queue.add(new ArrayList<Integer>(Arrays.asList(currentRow - 1, currentCol + 1)));
					queue.add(new ArrayList<Integer>(Arrays.asList(currentRow - 1, currentCol - 1)));
				}
			}
		}
		return count;
		
	}
	
	
	public static int getCountsDFS(int[][] matrix, int i, int j){
		if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
			return 0;
		}
		if(matrix[i][j] == 0){return 0;}
		int count = matrix[i][j]--;
		count += getCountsDFS(matrix, i + 1, j);
		count += getCountsDFS(matrix, i - 1, j);
		count += getCountsDFS(matrix, i, j + 1);
		count += getCountsDFS(matrix, i, j - 1);
		count += getCountsDFS(matrix, i + 1, j + 1);
		count += getCountsDFS(matrix, i + 1, j - 1);
		count += getCountsDFS(matrix, i - 1, j + 1);
		count += getCountsDFS(matrix, i - 1, j - 1);
		return count;
	}
	
	public static ArrayList<ArrayList<Integer>> getCoords(int i, int j, int m, int n){
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if(i - 1 > 0){
			list.add(new ArrayList<Integer>(Arrays.asList(i-1, j)));
			if(j - 1 > 0){
				list.add(new ArrayList<Integer>(Arrays.asList(i-1, j - 1)));
			}
			if(j + 1 < n){
				list.add(new ArrayList<Integer>(Arrays.asList(i - 1, j + 1)));
			}
			
		}
		if(i + 1 < m){
			list.add(new ArrayList<Integer>(Arrays.asList(i+1, j)));
			if(j - 1 > 0){
				list.add(new ArrayList<Integer>(Arrays.asList(i + 1, j - 1)));
			}
			if(j + 1 < n){
				list.add(new ArrayList<Integer>(Arrays.asList(i + 1, j + 1)));
			}
		}
		if(j - 1 > 0){
			list.add(new ArrayList<Integer>(Arrays.asList(i, j - 1)));
		}
		if(j + 1 < n){
			list.add(new ArrayList<Integer>(Arrays.asList(i, j + 1)));
		}

		return list;
	}
	
	
	public static void printGrid(boolean[][] grid){
		for(boolean[] arr : grid){
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void printGrid(int[][] grid){
		for(int[] arr : grid){
			System.out.println(Arrays.toString(arr));
		}
	}

}
