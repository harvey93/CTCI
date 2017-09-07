package ch16;

public class Intersection {
	
	public static Point isIntersecting(Point start1, Point end1, Point start2, Point end2) {
		Point res = null;
		if(start1.x > end1.x) swap(start1, end1);
		if(start2.x > end2.x) swap(start2, end2);
		if(start1.x > start2.x) {
			swap(start1, start2);
			swap(end1, end2);
		}
		
		Line line1 = new Line(start1, end1);
		Line line2 = new Line(start2, end2);
		
		double x = (line2.yInt - line1.yInt) / (line1.slope - line2.slope); 
		double y = line1.slope * x + line1.yInt;
		
		Point intersection = new Point (x, y);
		
		if(inBounds(start1, end1, intersection) && inBounds(start2, end2, intersection)) {
			res = intersection;
		}
		
		return res;
	}
	
	public static boolean inBounds(Point start, Point end, Point intersection) {
		return inBounds(start.x, end.x, intersection.x) &&
				inBounds(start.y, end.y, intersection.y);
	}
	
	public static boolean inBounds(double start, double end, double intersection) {
		if(start > end) {
			return start >= intersection && end <= intersection;
		}else {
			return start <= intersection && end >= intersection;
		}
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

class Line {
	double slope;
	double yInt;
	
	public Line(Point start, Point end) {
		double xDelta = end.x - start.x;
		double yDelta = end.y - start.y;
		this.slope = yDelta / xDelta;
		this.yInt = end.y - slope * end.x;
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