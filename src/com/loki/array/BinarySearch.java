package com.loki.array;

public class BinarySearch {

	private int[] arr = { 1, 3, 5, 6, 9, 11 };
	
	public int binarySearch(int low, int high, int key) {

		if (low > high)
			return -1;
		int mid = (low + high) / 2;
		while (low <= high) {
			if (arr[mid] == key) {
				System.out.println("element found at position " + mid);
				return mid;
			} else if (arr[mid] > key) {
				return binarySearch(low, mid - 1, key);
			} else {
				return binarySearch(mid + 1, high, key);
			}

		}
		return -1;
	}
	
	public void insert(int no){
		int i = 0;
		while(arr[i] < no){
			i++;
		}
		
		for(int j = i;j < arr.length -1;j++){
			int temp = arr[j+1]; 
			 arr[j+1] = arr[j] ;
			 arr[j] = no;
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		BinarySearch o = new BinarySearch();
		int length = o.arr.length;
		int i = o.binarySearch(0, length - 1, 15);
		if(i != -1){
			System.out.println("element found at : "+i);
		}
		else{
			System.out.println("element not found ");
		}
	}

}
