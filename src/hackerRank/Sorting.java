package hackerRank;

import java.util.*;

public class Sorting {
	
	public int inversions = 0;
	
	public static void mergeSort2(int [] arr){
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}
	
	public static void mergeSort(int [] arr, int[] temp, int leftStart, int rightEnd){
		if(leftStart >= rightEnd){
			return;
		}
		int middle = (leftStart + rightEnd) / 2;
		mergeSort(arr, temp, leftStart, middle);
		mergeSort(arr, temp, middle + 1, rightEnd);
		mergeHalves(arr, temp, leftStart, rightEnd);
	}
	
	public static void mergeHalves(int [] arr, int[] temp, int leftStart, int rightEnd){
		int leftEnd = (rightEnd + leftStart)/ 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd){
			if(arr[left] <= arr[right]){
				temp[index] = arr[left];
				left++;
			}else {
				
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);
		
	}
	
	
	
	public int [] mergeSort(int [] arr ){
		if(arr.length < 2){
			return arr;
		}
		int mid = arr.length / 2;
		int [] left = Arrays.copyOfRange(arr, 0, mid);
		int [] right = Arrays.copyOfRange(arr, mid, arr.length);
		return merge(mergeSort(left), mergeSort(right));
	}
	
	public int[] merge(int [] arr1, int [] arr2){
		int [] res = new int [arr1.length + arr2.length];
		int k = 0;
		int i = 0;
		int j = 0;
		while(i < arr1.length && j < arr2.length){
			if(arr1[i] <= arr2[j]){
				res[k] = arr1[i];
				k++;
				i++;
			}else{
				inversions += arr1.length - i;
				res[k] = arr2[j];
				k++;
				j++;
			}
		}
		for(; i < arr1.length; i++){
			res[k] = arr1[i];
			k++;
		}
		
		for(; j < arr2.length; j++){
			res[k] = arr2[j];
			k++;
		}
		
		return res;
	}
	
	
	public static int bubbleSort(int [] arr){
		int swaps = 0;
		int times = arr.length;
		boolean sorted = false;
		while(times > 0){
			sorted = true;
			for(int i = 0; i < arr.length - 1; i++){
				if(arr[i] > arr[i + 1]){
					sorted = false;
					exch(arr, i, i+1);
					swaps++;
				}
			}
			
			if(sorted){break;}
			times--;
		}
		return swaps;
	}
	
	public static void exch(int [] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void quicksort(int [] arr){
		ArrayList<Integer> list = new ArrayList<>();
		for(int i : arr){
			list.add(i);
		}
		Collections.shuffle(list);
		int index = 0;
		for(int el : list){
			arr[index] = el;
			index++;
		}
		
		quicksort(arr, 0, arr.length - 1);
	}
	
	
	private static void quicksort(int [] arr, int lo, int hi){
		if(lo >= hi){
			return;
		}
		int newLo = partition(arr, lo, hi);
		quicksort(arr, 0, newLo - 1);
		quicksort(arr, newLo + 1, hi);
		
		
	}
	
	
	public static int partition(int[] arr, int lo, int hi){
		int i = lo + 1;
		int j = hi;
		while(true){
			while(less(arr[i], arr[lo])){
				if(i == hi){break;}
				i++;
			}
			
			while(less(arr[lo], arr[j])){
				if(i == lo){break;}
				j--;
			}
			if(i >= j){break;}
			exch(arr, i, j);
		}
		exch(arr, lo, j);
		return j;
	}
	
	public static boolean less(int a, int b){
		return a < b;
	}
	
	
	
//	public static void quickSort(int [] arr){
//		quickSort(arr, 0, arr.length - 1);
//	}
	
//	public static void quickSort(int [] arr, int left, int right){
//		if(left >= right){
//			return;
//		}
//		
//		int pivot = arr[(left + right) / 2];
//		int index = partition(arr, left, right, pivot);
//		quickSort(arr, left, index - 1);
//		quickSort(arr, index, right);
//	}
//	
//	public static int partition(int[] arr, int left, int right, int pivot){
//		while(left <= right){
//			while(arr[left] < pivot){
//				left++;
//			}
//			
//			while(arr[right] > pivot){
//				right--;
//			}
//			
//			if(left <= right){
//				exch(arr, left, right);
//				left++;
//				right--;
//			}
//		}
//		return left;
//	}
	
//	public static ArrayList<Integer> quickSortList(ArrayList<Integer> arr){
//		if(arr.size() < 2){
//			return arr;
//		}
//		System.out.println(arr);
//		int pivot = arr.get(0);
//		ArrayList<Integer> left = new ArrayList<>();
//		ArrayList<Integer> right = new ArrayList<>();
//		arr.forEach(el -> {
//			if(el > pivot){
//				right.add(el);
//			}else {
//				left.add(el);
//			}
//		});
//		
//		ArrayList<Integer> sortedLeft = quickSortList(left);
//		sortedLeft.add(pivot);
//		ArrayList<Integer> sortedRight = quickSortList(right);
//		sortedLeft.addAll(right);
//		return sortedLeft;
//		
//	}
	

}
