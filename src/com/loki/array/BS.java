package com.loki.array;

public class BS {
	
	public void bs(int low, int high,int[] arr,int n){
		
		if(low > high) return;
		
		int mid = (low + high)/2;
		
		if(arr[mid] == n){
			System.out.println("found at position "+mid);
		}
		else if(arr[mid] > n){
			bs(low, mid - 1, arr, n);
		}
		else{
			bs(mid + 1,high, arr, n);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int x = 6;
		BS bs = new BS();
		bs.bs(0, arr.length - 1, arr, x);

	}

}
