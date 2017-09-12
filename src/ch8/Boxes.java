package ch8;


import java.util.*;

public class Boxes {
	

	public static int createStack(ArrayList<Box> boxes) {
		
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		for(int i = 0; i < boxes.size(); i++) {
			int height = createStack(boxes, i);
			if(height > maxHeight) {
				maxHeight = height;
			}
		}
		
		return maxHeight;
	}
	
	public static int createStack(ArrayList<Box> boxes, int index) {
		Box bottom = boxes.get(index);
		
		int maxHeight = 0;
		
		for(int j = index + 1; j < boxes.size(); j++) {
			Box current = boxes.get(j);
			if(current.canBeAbove(bottom)) {
				int height = createStack(boxes, j);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		
		maxHeight += bottom.h;
		return maxHeight;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static int createStack(ArrayList<Box> list){
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		Collections.sort(list, new BoxComparator());
//		System.out.println(list);
//		int maxHeight = 0;
//		for(int i = 0; i < list.size(); i++){
//			int height = createStack(list, i, map);
//			maxHeight = Math.max(maxHeight, height);
//		}
//		return maxHeight;
//	}
//	
//	
//	public static int createStack(ArrayList<Box> boxes, int index, HashMap<Integer, Integer> map){
//		if(map.containsKey(index)){
//			return map.get(index);
//		}
//		
//		Box bottom = boxes.get(index);
//		int maxHeight = 0;
//		for(int i = index + 1; i < boxes.size(); i++){
//			Box current = boxes.get(i);
//			if(current.canBeAbove(bottom)){
//				
//				int height = createStack(boxes, i, map);
//				maxHeight = Math.max(maxHeight, height);
//			}
//		}
//		maxHeight += bottom.h;
//		map.put(index, maxHeight);
//		return maxHeight;
//	}

}

class Box{
	Integer h;
	Integer w;
	Integer d;
	
	public boolean canBeAbove(Box below){
		return (below.h > this.h) && (below.w > this.w) && (below.d > this.d);
	}
	
	public Box(int h, int w, int d){
		this.h = h;
		this.w = w;
		this.d = d;
	}
	
	public String toString(){
		return this.h.toString();
	} 
}

class BoxComparator implements Comparator<Box>{

	
	@Override
	public int compare(Box o1, Box o2) {
		// TODO Auto-generated method stub
		return -1 * o1.h.compareTo(o2.h);
	}
}