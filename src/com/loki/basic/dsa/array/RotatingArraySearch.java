package com.loki.basic.dsa.array;

public class RotatingArraySearch {
	static int[] arr = {7 ,8 ,9 ,10 ,11 ,1 ,2 ,3 ,4 ,5 ,6};
	int to_search = 10;
	
	public int findRotationIndex(){
		for(int i= 0,j = 1; j < arr.length;i++,j++){
			if(arr[i] > arr[j]){
				return j;
			}
		}
		return -1;
	}
	
	
	public boolean binarySearch(int low, int high){
		if(low > high) return false;
		
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(arr[mid] == to_search){
				System.out.println("found at position => "+(mid+1));
				return true;
			}
			else if(arr[mid] > to_search){
				high = mid - 1;
				
			}
			else{
				low = mid + 1;
				
			}
		}
		
		System.out.println("not found");
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		RotatingArraySearch rt = new RotatingArraySearch();
		int pivot = rt.findRotationIndex();
		
		if(rt.binarySearch(0, pivot-1)){
			
		}
		else{
		rt.binarySearch(pivot, arr.length - 1);
		}


	}

}
