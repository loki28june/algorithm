package com.loki.array;

public class SlidingWindow {
	private int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
	private int w = 3;
	private int[] b = new int[arr.length - w + 1];

	public void populateArray() {
		
		int start = 0, end = w - 1,max = 0;
		while (end < arr.length) {
			for (int i = start; i <= end; i++) {
				if (arr[i] > max) {
					max = arr[i];
				}
			}

			b[start] = max;
			start++;
			end++;
			max = 0;

		}
	}
	

	
	public void print(int[] a){
		for(int i : a){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	


	public static void main(String[] args) {
		SlidingWindow sw = new SlidingWindow();
		sw.print(sw.arr);
		sw.populateArray();
		sw.print(sw.b);
		
	}

}
