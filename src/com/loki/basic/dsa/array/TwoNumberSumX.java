package com.loki.basic.dsa.array;

public class TwoNumberSumX {

	public void printPairs(int x, int[] arr) {
		boolean[] ref = new boolean[10000]; // we need to know the range within
											// which value of array elements
											// lies

		for (int i = 0; i < arr.length; i++) {
			int temp = x - arr[i];

			if (temp >= 0 && ref[temp]) {
				System.out.println("pairs whose sum is " + x + " is => " + temp + " and " + arr[i]);
			}
			ref[arr[i]] = true;
			
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 45, 6, 10, 8 };
		int x = 16;
		TwoNumberSumX pair = new TwoNumberSumX();
		pair.printPairs(x, arr);
	}

}
