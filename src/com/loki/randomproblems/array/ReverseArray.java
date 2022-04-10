package com.loki.randomproblems.array;

public class ReverseArray {
	private int[] arr = { 1, 3, 5, 6, 9, 11 };
	
	public void reverse(){
		int i = 0,j = arr.length - 1;
		for(;i < j;i++,j--){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
	}
	
	public void printArray(){
		for(int i : arr){
			System.out.print(i+" ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		ReverseArray rev = new ReverseArray();
		rev.printArray();
		rev.reverse();
		rev.printArray();

	}

}
