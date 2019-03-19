package com.loki.array;

public class BinarySearchRecursion {

	public int binarySearch(int low, int high, int[] arr, int n) {
		if (low > high)
			return -1;
		int mid = (low + high) / 2;

		if (arr[mid] == n) {
			return (mid + 1);
		} else if (arr[mid] > n) {
			return binarySearch(low, mid - 1, arr, n);
		} else {
			return binarySearch(mid + 1, high, arr, n);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int x = 6;
		BinarySearchRecursion binarySearchrecursion = new BinarySearchRecursion();
		int position = binarySearchrecursion.binarySearch(0, arr.length - 1, arr, x);
		System.out.println(position);

	}

}
