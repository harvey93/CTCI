package hackerRank;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
	
	public static double [] getMedians(int [] arr){
		PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return -1 * a.compareTo(b);
			}
			
		});
		
		PriorityQueue<Integer> highers = new PriorityQueue<>();
		
		double [] medians = new double[arr.length];
		for(int i = 0; i < arr.length; i++){
			Integer number = arr[i];
			addNumber(number, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		return medians;
	}
	
	public static void addNumber(Integer number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		if(lowers.isEmpty() || number < lowers.peek()){
			lowers.add(number);
		}else {
			highers.add(number);
		}
	}
	
	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		PriorityQueue<Integer> smaller = lowers.size() < highers.size() ? lowers : highers;
		PriorityQueue<Integer> bigger = lowers.size() < highers.size() ? highers : lowers;
		if(bigger.size() - smaller.size() > 1){
			smaller.add(bigger.poll());
		}
	}
	
	public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		PriorityQueue<Integer> smaller = lowers.size() < highers.size() ? lowers : highers;
		PriorityQueue<Integer> bigger = lowers.size() < highers.size() ? highers : lowers;
		if(smaller.size() == bigger.size()){
			return ((double)(smaller.peek() + bigger.peek())) / 2;
		}else {
			return bigger.peek();
		}
		
	}
		
}
