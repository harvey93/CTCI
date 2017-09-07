package ch8;

public class MagicIndex {
	
	
	public static int findIndexDups(int [] arr){
		return findIndexDups(arr, 0, arr.length - 1);
	}
	
	public static int findIndexDups(int [] arr, int start, int end){
		if(end < start){
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == mid){
			return mid;
		}
		
		int leftIndex = Math.min(mid - 1, arr[mid]);
		
		int left = findIndexDups(arr, start, leftIndex);
		
		if(left >= 0){
			return left;
		}
		
		int rightIndex = Math.max(mid + 1, arr[mid]);
		int right = findIndexDups(arr, rightIndex, end);
		
		return right;
		
		
		
	}

	public static int findIndexUnique(int [] arr){
		return findIndexUnique(arr, 0, arr.length - 1);
	}
	
	public static int findIndexUnique(int [] arr, int start, int end){
		if(end < start){
			return -1;
		}
		int mid = (start + end) / 2;
		if(arr[mid] == mid){
			return mid;
		}else if(mid > arr[mid]){
			return findIndexUnique(arr, mid + 1, end);
		}else {
			return findIndexUnique(arr, start, mid - 1);
		}
	}
}
