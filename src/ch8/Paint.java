package ch8;

public class Paint {
	
	public static boolean fillPaint(Color[][] screen, int row, int col, Color ncolor){
		Color ocolor = screen[row][col];
		if(ocolor == ncolor){
			return false;
		}
		
		return fillPaint(screen, row, col, ocolor, ncolor);
	}
	
	
	public static boolean fillPaint(Color[][] screen, int row, int col, Color ocolor, Color ncolor){
		if(row < 0 || row >= screen.length || col < 0 || col >= screen[0].length){
			return false;
		}
		
		if(screen[row][col] == ocolor){
			screen[row][col] = ncolor;
			fillPaint(screen, row + 1, col, ocolor, ncolor);
			fillPaint(screen, row - 1, col, ocolor, ncolor);
			fillPaint(screen, row, col + 1, ocolor, ncolor);
			fillPaint(screen, row, col - 1, ocolor, ncolor);
		}
		
		return true;
	}

	
//	public static boolean fillPaint(Color[][] screen, int row, int col, Color ncolor){
//		if(screen[row][col] == ncolor){
//			return false;
//		}
//		
//		return fillPaint(screen, row, col, screen[row][col], ncolor);
//	}
//	
//	public static boolean fillPaint(Color[][] screen, int row, int col, Color ocolor, Color ncolor){
//		if(row < 0 || row >= screen.length){
//			return false;
//		}else if(col < 0 || col >= screen[0].length){
//			return false;
//		}
//		
//		if(screen[row][col] == ocolor){
//			screen[row][col] = ncolor;
//			fillPaint(screen, row + 1, col, ocolor, ncolor);
//			fillPaint(screen, row - 1, col, ocolor, ncolor);
//			fillPaint(screen, row, col + 1, ocolor, ncolor);
//			fillPaint(screen, row, col - 1, ocolor, ncolor);
//		}
//		
//		
//		
//		return true;
//	}


}


enum Color{
	B, W, R, Y, G;
	
	
}
