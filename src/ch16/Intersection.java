package ch16;

public class Intersection {
	
	public static boolean isIntersecting(Point start1, Point end1, Point start2, Point end2) {
		boolean res = true;
		return res;
	}
	
	public static void swap(Point p1, Point p2) {
		double x = p1.x;
		double y = p1.y;
		p1.x = p2.x;
		p1.y = p2.y;
		p2.x = x;
		p2.y = y;
	}

}

class Point{
	double x;
	double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}