package com.loki.randomproblems.corejava;

public class MaximumSequence {

	public static void main(String[] args) {
		int max = 0;
		int[] arr = { 2, 5, 6, 3, 7, 6, 5, 8 };
		int count = 0;
		
		for (int i = 0; (i + 1) < arr.length; i++) {

			if (Math.abs(arr[i] - arr[i + 1]) == 1) {
				count++;
			} else {
				if (count > max) {
					max = count;
				}
			}
		}
		System.out.println(max);

	}

}
