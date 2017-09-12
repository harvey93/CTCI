package ch8;


import java.util.*;

public class Test {
	
	static int[][] matrix = {
			{1,1,1,1,1,1,1,1},
			{1,1,0,1,1,1,0,1},
			{1,1,1,1,0,1,1,1},
			{0,1,0,1,1,0,1,1},
			{1,1,0,1,1,1,1,1},
			{1,1,1,0,0,1,0,1},
			{1,0,1,1,1,0,1,1},
			{1,1,1,1,1,1,1,1}
	};
	
	static Color[][] screen = {
			{Color.W, Color.W, Color.W, Color.W, Color.W, Color.W, Color.W},
			{Color.W, Color.W, Color.B, Color.B, Color.B, Color.B, Color.W},
			{Color.W, Color.W, Color.B, Color.W, Color.W, Color.B, Color.W},
			{Color.W, Color.W, Color.B, Color.W, Color.W, Color.B, Color.W},
			{Color.W, Color.W, Color.B, Color.W, Color.W, Color.B, Color.W},
			{Color.W, Color.W, Color.B, Color.B, Color.B, Color.B, Color.W},
			{Color.W, Color.W, Color.W, Color.W, Color.W, Color.W, Color.W},
			{Color.W, Color.W, Color.W, Color.W, Color.W, Color.W, Color.W},
			
			
	};
	
//	ArrayList<Box> list = new ArrayList<>();
//	list.add(new Box(15, 12, 10));
//	list.add(new Box(14, 9, 8));
//	list.add(new Box(12, 8, 4));
//	list.add(new Box(10, 6, 7));
//	list.add(new Box(9, 5, 16));
//	list.add(new Box(8, 4, 12));
//	list.add(new Box(7, 4, 4));
//	list.add(new Box(3, 13, 3));
//	list.add(new Box(2, 2, 2));
// countEval("1^0|0|1", false)


	public static void main(String[] args) {		
		System.out.println(BooleanEvaluation.countEval("1^0|0|1", false));
	}
}









